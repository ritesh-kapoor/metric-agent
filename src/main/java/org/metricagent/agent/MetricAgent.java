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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class MetricAgent implements ClassFileTransformer {
    private static final String CONFIGURATION_FILENAME = "configuration.xml";
    private static Logger log = LoggerFactory.getLogger(MetricAgent.class);
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
            log.info("Reporting via Graphite; name : {}, URL :{} , port :{} , period : {}, batchSize: {}",
                    graphite.getName(), graphite.getUrl(), graphite.getPort().intValue(),
                    graphite.getPeriod().intValue(), graphite.getBatchSize());
        } else if (configuration.getReporting().getCsv() != null) {
            Csv csv = (Csv) configuration.getReporting().getCsv();
            log.info("Reporting via Csv path :{} period :{}", csv.getPath(), csv.getPeriod().intValue());
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
        if (aClass != null) log.debug("Class redefined {}", className);

        log.debug("Loading class {}", className);

        boolean doInstrument = false;
        for (Metric metric : configuration.getMetrics().getMeterOrTimer()) {
            if (className.matches(metric.getPackage())) {
                doInstrument = true;
                break;
            }
        }

        if (doInstrument) {
            log.info("Weaving class {}", className);
        } else {
            log.debug("Not weaving class {}", className);
            return classfileBuffer;
        }

        ClassPool classPool = new ClassPool();
        classPool.appendSystemPath();
        CtClass ctClass = null;
        try {
            ctClass = classPool.get(className);
            if (ctClass.isFrozen()) {
                log.debug("Skip class {}: is frozen", className);
                return null;
            }

            if (ctClass.isPrimitive() || ctClass.isArray() || ctClass.isAnnotation()
                    || ctClass.isEnum() || ctClass.isInterface()) {
                log.debug("Skip class {}: not a class", className);
                return null;
            }

            boolean isClassModified = false;

            for (Metric metric : configuration.getMetrics().getMeterOrTimer()) {
                if (!className.matches(metric.getPackage())) continue;
                for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                    //String signature= Modifier.toString(ctMethod.getModifiers())+" "+ctMethod.getLongName();
                    String signature = ctMethod.getLongName();
                    if (!signature.matches(metric.getMethodRegex())) {
                        log.info("Not weaving method {}", signature);
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
                        log.info("Skipping instrumentation of methods for class {} exception {}", ctClass.getName(),
                                ExceptionUtils.getStackTrace(e));
                    }
                }
            }

            if (isClassModified) {
                log.info("Completed weaving class {}", className);
                return ctClass.toBytecode();
            }
        } catch (Exception e) {
            log.info("Exception occurred while weaving class {} with Exception : {} ",
                    className, ExceptionUtils.getStackTrace(e));
        }


        return classfileBuffer;
    }
}
