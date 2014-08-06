package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reporting" type="{http://www.metricsagent.com/schema/configuration}reporting"/>
 *         &lt;element name="metrics" type="{http://www.metricsagent.com/schema/configuration}metrics"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "reporting",
        "metrics"
})
@XmlRootElement(name = "configuration", namespace = "http://www.metricsagent.com/schema/configuration")
public class Configuration {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    protected Reporting reporting;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    protected Metrics metrics;

    /**
     * Gets the value of the reporting property.
     *
     * @return possible object is
     * {@link Reporting }
     */
    public Reporting getReporting() {
        return reporting;
    }

    /**
     * Sets the value of the reporting property.
     *
     * @param value allowed object is
     *              {@link Reporting }
     */
    public void setReporting(Reporting value) {
        this.reporting = value;
    }

    /**
     * Gets the value of the metrics property.
     *
     * @return possible object is
     * {@link Metrics }
     */
    public Metrics getMetrics() {
        return metrics;
    }

    /**
     * Sets the value of the metrics property.
     *
     * @param value allowed object is
     *              {@link Metrics }
     */
    public void setMetrics(Metrics value) {
        this.metrics = value;
    }

}
