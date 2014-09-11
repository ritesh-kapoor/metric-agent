
package org.metricagent.configuration.marshal;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for csv complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="csv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csv", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
    "path",
    "period"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
public class Csv {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected String path;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected BigInteger period;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public void setPath(String value) {
        this.path = value;
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

}
