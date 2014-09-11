
package org.metricagent.configuration.marshal;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for graphite complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="graphite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="batchSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graphite", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
    "name",
    "url",
    "port",
    "period",
    "batchSize"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
public class Graphite {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected String name;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected String url;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected BigInteger port;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true, defaultValue = "5000")
    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected BigInteger period;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true, defaultValue = "50")
    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected BigInteger batchSize;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public BigInteger getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setPort(BigInteger value) {
        this.port = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setPeriod(BigInteger value) {
        this.period = value;
    }

    /**
     * Gets the value of the batchSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public BigInteger getBatchSize() {
        return batchSize;
    }

    /**
     * Sets the value of the batchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setBatchSize(BigInteger value) {
        this.batchSize = value;
    }

}
