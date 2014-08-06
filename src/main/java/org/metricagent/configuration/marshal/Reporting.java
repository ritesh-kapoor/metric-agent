package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reporting complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="reporting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="graphite" type="{http://www.metricsagent.com/schema/configuration}graphite" minOccurs="0"/>
 *           &lt;element name="csv" type="{http://www.metricsagent.com/schema/configuration}csv" minOccurs="0"/>
 *           &lt;element name="jmx" type="{http://www.metricsagent.com/schema/configuration}jmx" minOccurs="0"/>
 *           &lt;element name="console" type="{http://www.metricsagent.com/schema/configuration}console" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reporting", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
        "graphite",
        "csv",
        "jmx",
        "console"
})
public class Reporting {

    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration")
    protected Graphite graphite;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration")
    protected Csv csv;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration")
    protected Jmx jmx;
    @XmlElement(namespace = "http://www.metricsagent.com/schema/configuration")
    protected Console console;

    /**
     * Gets the value of the graphite property.
     *
     * @return possible object is
     * {@link Graphite }
     */
    public Graphite getGraphite() {
        return graphite;
    }

    /**
     * Sets the value of the graphite property.
     *
     * @param value allowed object is
     *              {@link Graphite }
     */
    public void setGraphite(Graphite value) {
        this.graphite = value;
    }

    /**
     * Gets the value of the csv property.
     *
     * @return possible object is
     * {@link Csv }
     */
    public Csv getCsv() {
        return csv;
    }

    /**
     * Sets the value of the csv property.
     *
     * @param value allowed object is
     *              {@link Csv }
     */
    public void setCsv(Csv value) {
        this.csv = value;
    }

    /**
     * Gets the value of the jmx property.
     *
     * @return possible object is
     * {@link Jmx }
     */
    public Jmx getJmx() {
        return jmx;
    }

    /**
     * Sets the value of the jmx property.
     *
     * @param value allowed object is
     *              {@link Jmx }
     */
    public void setJmx(Jmx value) {
        this.jmx = value;
    }

    /**
     * Gets the value of the console property.
     *
     * @return possible object is
     * {@link Console }
     */
    public Console getConsole() {
        return console;
    }

    /**
     * Sets the value of the console property.
     *
     * @param value allowed object is
     *              {@link Console }
     */
    public void setConsole(Console value) {
        this.console = value;
    }

}
