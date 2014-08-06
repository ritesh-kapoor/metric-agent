package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for metrics complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metrics", namespace = "http://www.metricsagent.com/schema/configuration", propOrder = {
        "meterOrTimer"
})
public class Metrics {

    @XmlElements({
            @XmlElement(name = "meter", namespace = "http://www.metricsagent.com/schema/configuration", type = Meter.class),
            @XmlElement(name = "timer", namespace = "http://www.metricsagent.com/schema/configuration", type = Timer.class)
    })
    protected List<Metric> meterOrTimer;

    /**
     * Gets the value of the meterOrTimer property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meterOrTimer property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterOrTimer().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Meter }
     * {@link Timer }
     */
    public List<Metric> getMeterOrTimer() {
        if (meterOrTimer == null) {
            meterOrTimer = new ArrayList<Metric>();
        }
        return this.meterOrTimer;
    }

}
