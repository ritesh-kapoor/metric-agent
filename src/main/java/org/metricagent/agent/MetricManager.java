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

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Meter;
import com.yammer.metrics.core.Metric;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;
import com.yammer.metrics.reporting.ConsoleReporter;
import com.yammer.metrics.reporting.CsvReporter;
import com.yammer.metrics.reporting.GraphiteReporter;
import com.yammer.metrics.reporting.JmxReporter;
import javassist.*;
import org.metricagent.metrics.MetricType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class MetricManager {

    public static MetricManager metricManager = new MetricManager();
    private static Logger log = LoggerFactory.getLogger(MetricAgent.class);
    private Map<String, Metric> metricMap = new ConcurrentHashMap();

    public static MetricManager getInstance() {
        return metricManager;
    }

    public void initializeConsoleReporter(long period) {
        ConsoleReporter.enable(period, TimeUnit.MILLISECONDS);
    }

    public void initializeCsvReporter(String directory, long period) {
        CsvReporter.enable(new File(directory), period, TimeUnit.MILLISECONDS);
    }

    public void initializeGraphiteReporter(String host, int port, long period) {
        GraphiteReporter.enable(period, TimeUnit.MILLISECONDS, host, port);
    }

    public void initializeJmxRerporter() {
        JmxReporter.startDefault(Metrics.defaultRegistry());
    }

    public Meter getMeter(String name) {
        if (!metricMap.containsKey(name)) {
            metricMap.put(name, Metrics.newMeter(MetricManager.class, name, name, TimeUnit.SECONDS));
        }
        return (Meter) metricMap.get(name);
    }


    public Timer getTimer(String name) {
        if (!metricMap.containsKey(name)) {
            metricMap.put(name, Metrics.newTimer(MetricManager.class, name));
        }
        return (Timer) metricMap.get(name);
    }


    public void instrumentForMeter(String name, boolean before, CtClass clazz, CtMethod method) throws CannotCompileException {
        log.info("Instrumenting class {} method {} with {} metric", clazz.getName(),
                method.getLongName(), MetricType.METER.name());
        if (before) {
            method.insertBefore(String.format("%s.getInstance().getMeter(\"%s\").mark();", MetricManager.class.getName(), name));
        } else {
            method.insertAfter(String.format("%s.getInstance().getMeter(\"%s\").mark();", MetricManager.class.getName(), name));
        }
        log.info("Instrumention completed for method {} with {} metric {}", method.getName(), MetricType.METER.name(), name);

    }

    public void instrumentForTimer(String name, CtClass clazz, CtMethod method) throws CannotCompileException {
        MetricType metricType = MetricType.TIMER;
        log.info("Instrumenting class {} method {} with {} metric", clazz.getName(),
                method.getLongName(), metricType.name());
        try {
            method.addLocalVariable("$timerContext", ClassPool.getDefault().get(TimerContext.class.getName()));
        } catch (NotFoundException e) {
            throw new CannotCompileException("Cannot find class", e);
        }
        method.insertBefore(
                String.format("$timerContext=%s.getInstance().getTimer(\"%s\").time();", MetricManager.class.getName(), name)
        );
        method.insertAfter(String.format("$timerContext.stop();", name));
        log.info("Instrumention completed for method {} with {} metric {}", method.getName(), metricType.name(), name);
    }

}
