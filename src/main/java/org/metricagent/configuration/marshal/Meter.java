package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for meter complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="meter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.metricsagent.com/schema/configuration}metric">
 *       &lt;attribute name="placement">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="before"/>
 *             &lt;enumeration value="after"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meter", namespace = "http://www.metricsagent.com/schema/configuration")
public class Meter
        extends Metric {

    @XmlAttribute(name = "placement")
    protected String placement;

    /**
     * Gets the value of the placement property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPlacement(String value) {
        this.placement = value;
    }

}
