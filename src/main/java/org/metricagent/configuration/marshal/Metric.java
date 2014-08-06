package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for metric complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="metric">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="package" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="methodRegex" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metric", namespace = "http://www.metricsagent.com/schema/configuration")
@XmlSeeAlso({
        Meter.class,
        Timer.class
})
public class Metric {

    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "package", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String _package;
    @XmlAttribute(name = "methodRegex", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String methodRegex;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the package property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPackage(String value) {
        this._package = value;
    }

    /**
     * Gets the value of the methodRegex property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMethodRegex() {
        return methodRegex;
    }

    /**
     * Sets the value of the methodRegex property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMethodRegex(String value) {
        this.methodRegex = value;
    }

}
