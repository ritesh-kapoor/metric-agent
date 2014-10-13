/**
 * Copyright (C) 2014 Ritesh Kapoor (ccoder4u@yahoo.co.in)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.metricagent.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.metricagent.configuration.ConfigurationManager;
import org.metricagent.configuration.marshal.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.ProtectionDomain;

public class MetricAgent implements ClassFileTransformer {
    private static final String CONFIGURATION_FILENAME = "configuration.xml";
    private static Log log = Log.getLogger(MetricAgent.class);
    private static Configuration configuration;

    public static void premain(String agentArgument,
                               Instrumentation instrumentation) {

        //BasicConfigurator.configure();
        log.info("Starting Metric Agent");
        configuration = ConfigurationManager.getInstance().loadFromFile(CONFIGURATION_FILENAME);

        log.info("Configuration : " + configuration.getReporting());

        if (configuration.getReporting().getGraphite() != null) {
            Graphite graphite = configuration.getReporting().getGraphite();
            MetricManager.getInstance().initializeGraphiteReporter(graphite.getName(), graphite.getUrl(), graphite.getPort().intValue()
                    , graphite.getPeriod().intValue(), graphite.getBatchSize().intValue());
            log.info("Reporting via Graphite; name : {0}, URL :{1} , port :{2} , period : {3}, batchSize: {4}",
                    graphite.getName(), graphite.getUrl(), graphite.getPort().intValue(),
                    graphite.getPeriod().intValue(), graphite.getBatchSize().intValue());
        } else if (configuration.getReporting().getCsv() != null) {
            Csv csv = (Csv) configuration.getReporting().getCsv();
            log.info("Reporting via Csv path :{0} period :{1}", csv.getPath(), csv.getPeriod().intValue());
            MetricManager.getInstance().initializeCsvReporter(csv.getPath(), csv.getPeriod().intValue());
        } else if (configuration.getReporting().getConsole() != null) {
            MetricManager.getInstance().initializeConsoleReporter(configuration.getReporting()
                    .getConsole().getPeriod().intValue());
            log.info("Reporting via Console");
        } else if (configuration.getReporting().getJmx() != null) {
            log.info("Reporting via JMX");
            MetricManager.getInstance().initializeJmxRerporter();
        }

        instrumentation.addTransformer(new MetricAgent());
    }


    @Override
    public byte[] transform(ClassLoader classLoader, String className,
                            Class<?> aClass, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        className = className.replace("/", ".");
        if (aClass != null) log.info("Class redefined {0}", className);

        //log.info("Loading class {0}", className);

        boolean doInstrument = false;
        for (Metric metric : configuration.getMetrics().getMeterOrTimer()) {
            if (className.matches(metric.getPackage())) {
                doInstrument = true;
                break;
            }
        }

        if (doInstrument) {
            log.info("Weaving class {0}", className);
        } else {
            //log.info("Not weaving class {0}", className);
            return classfileBuffer;
        }

        ClassPool classPool = new ClassPool();
        classPool.appendSystemPath();

        try{
            if(classLoader instanceof URLClassLoader) {
                log.info("Attempting to load URL class loader.");
                URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
                for (URL url : urlClassLoader.getURLs()) {
                    log.info("Adding class path {0}",url.getPath());
                    classPool.appendClassPath(url.getPath());
                }
            }
        }catch (Exception e){
            log.info("Unable to load class path. Exception : {0}", ExceptionUtils.getStackTrace(e));
        }


        CtClass ctClass = null;
        try {
            ctClass = classPool.get(className);
            if (ctClass.isFrozen()) {
                log.info("Skip class {0}: is frozen", className);
                return null;
            }

            if (ctClass.isPrimitive() || ctClass.isArray() || ctClass.isAnnotation()
                    || ctClass.isEnum() || ctClass.isInterface()) {
                log.info("Skip class {0}: not a class", className);
                return null;
            }

            boolean isClassModified = false;

            for (Metric metric : configuration.getMetrics().getMeterOrTimer()) {
                if (!className.matches(metric.getPackage())) continue;
                for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                    //String signature= Modifier.toString(ctMethod.getModifiers())+" "+ctMethod.getLongName();
                    String signature = ctMethod.getLongName();
                    if (!signature.matches(metric.getMethodRegex())) {
                        log.info("Not weaving method {0}", signature);
                        continue;
                    }
                    try {
                        if (metric instanceof Meter) {
                            MetricManager.getInstance().instrumentForMeter(metric.getName(),
                                    ((Meter) metric).getPlacement().equals("before"), ctClass, ctMethod);
                        } else if (metric instanceof Timer) {
                            MetricManager.getInstance().instrumentForTimer(metric.getName(), ctClass, ctMethod);
                        }
                        isClassModified = true;
                    } catch (Exception e) {
                        log.info("Skipping instrumentation of methods for class {0} exception {1}", ctClass.getName(),
                                ExceptionUtils.getStackTrace(e));
                    }
                }
            }

            if (isClassModified) {
                log.info("Completed weaving class {0}", className);
                return ctClass.toBytecode();
            }
        } catch (Exception e) {
            log.info("Exception occurred while weaving class {0} with Exception : {1} ",
                    className, ExceptionUtils.getStackTrace(e));
        }


        return classfileBuffer;
    }
}
