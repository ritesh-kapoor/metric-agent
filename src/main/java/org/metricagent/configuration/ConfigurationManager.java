/**
 * Copyright (C) 2014 Ritesh Kapoor (ccoder4u@yahoo.co.in)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.metricagent.configuration;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.metricagent.configuration.marshal.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConfigurationManager {

    static Logger log = LoggerFactory.getLogger(ConfigurationManager.class);

    private static ConfigurationManager INSTANCE = new ConfigurationManager();

    public static ConfigurationManager getInstance() {
        return INSTANCE;
    }

    public Configuration loadFromFile(String name) {
        try {
            log.info("Loading configuration file {}", name);

            JAXBContext jc = JAXBContext.newInstance(Configuration.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            InputStream xml = new FileInputStream(name);
            JAXBElement<Configuration> configurationElement = unmarshaller.unmarshal(new StreamSource(xml), Configuration.class);
            xml.close();
            Configuration configuration = configurationElement.getValue();

           /* Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(configurationElement, System.out);*/

            log.info("Successfully loaded configuration file {}", name);
            return configuration;
        } catch (Exception e) {
            log.error("Unable to load configuration file {}", name, ExceptionUtils.getStackTrace(e));
            throw new RuntimeException(e);

        }
    }
}
