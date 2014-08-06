package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for csv complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csv", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
        "path",
        "period"
})
public class Csv {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    protected String path;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger period;

    /**
     * Gets the value of the path property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the period property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setPeriod(BigInteger value) {
        this.period = value;
    }

}
