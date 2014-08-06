package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for graphite complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="graphite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graphite", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
        "url",
        "port",
        "period"
})
public class Graphite {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    protected String url;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger port;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration", required = true, defaultValue = "5000")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger period;

    /**
     * Gets the value of the url property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the port property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setPort(BigInteger value) {
        this.port = value;
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
