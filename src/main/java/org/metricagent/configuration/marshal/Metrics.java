
package org.metricagent.configuration.marshal;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for metrics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metrics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="meter" type="{http://www.metricsagent.com/schema/configuration}meter"/>
 *         &lt;element name="timer" type="{http://www.metricsagent.com/schema/configuration}timer"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metrics", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
    "meterOrTimer"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
public class Metrics {

    @XmlElements({
        @XmlElement(name = "meter", namespace = "http://www.metricsagent.com/schema/configuration", type = Meter.class),
        @XmlElement(name = "timer", namespace = "http://www.metricsagent.com/schema/configuration", type = Timer.class)
    })
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    protected List<Metric> meterOrTimer;

    /**
     * Gets the value of the meterOrTimer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meterOrTimer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterOrTimer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Meter }
     * {@link Timer }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2014-09-11T05:25:30+05:30", comments = "JAXB RI v2.2.7")
    public List<Metric> getMeterOrTimer() {
        if (meterOrTimer == null) {
            meterOrTimer = new ArrayList<Metric>();
        }
        return this.meterOrTimer;
    }

}
