package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for console complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="console">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "console", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
        "period"
})
public class Console {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger period;

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
