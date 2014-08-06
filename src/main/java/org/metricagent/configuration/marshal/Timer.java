package org.metricagent.configuration.marshal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timer complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="timer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.metricsagent.com/schema/configuration}metric">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timer", namespace = "http://www.metricsagent.com/schema/configuration")
public class Timer
        extends Metric {


}
