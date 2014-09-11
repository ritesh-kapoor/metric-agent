
package org.metricagent.configuration.marshal;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reporting",
    "metrics"
})
@XmlRootElement(name = "configuration", namespace = "http://www.metricsagent.com/schema/configuration")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
public class Configuration {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected Reporting reporting;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected Metrics metrics;

    /**
     * Gets the value of the reporting property.
     * 
     * @return
     *     possible object is
     *     {@link Reporting }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public Reporting getReporting() {
        return reporting;
    }

    /**
     * Sets the value of the reporting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reporting }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setReporting(Reporting value) {
        this.reporting = value;
    }

    /**
     * Gets the value of the metrics property.
     * 
     * @return
     *     possible object is
     *     {@link Metrics }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public Metrics getMetrics() {
        return metrics;
    }

    /**
     * Sets the value of the metrics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Metrics }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setMetrics(Metrics value) {
        this.metrics = value;
    }

}
