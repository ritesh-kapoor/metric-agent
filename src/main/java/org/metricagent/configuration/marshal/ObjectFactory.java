
package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.metricagent.configuration.marshal package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.metricagent.configuration.marshal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Configuration }
     * 
     */
    public Configuration createConfiguration() {
        return new Configuration();
    }

    /**
     * Create an instance of {@link Reporting }
     * 
     */
    public Reporting createReporting() {
        return new Reporting();
    }

    /**
     * Create an instance of {@link Metrics }
     * 
     */
    public Metrics createMetrics() {
        return new Metrics();
    }

    /**
     * Create an instance of {@link Graphite }
     * 
     */
    public Graphite createGraphite() {
        return new Graphite();
    }

    /**
     * Create an instance of {@link Meter }
     * 
     */
    public Meter createMeter() {
        return new Meter();
    }

    /**
     * Create an instance of {@link Console }
     * 
     */
    public Console createConsole() {
        return new Console();
    }

    /**
     * Create an instance of {@link Jmx }
     * 
     */
    public Jmx createJmx() {
        return new Jmx();
    }

    /**
     * Create an instance of {@link Timer }
     * 
     */
    public Timer createTimer() {
        return new Timer();
    }

    /**
     * Create an instance of {@link Metric }
     * 
     */
    public Metric createMetric() {
        return new Metric();
    }

    /**
     * Create an instance of {@link Csv }
     * 
     */
    public Csv createCsv() {
        return new Csv();
    }

}
