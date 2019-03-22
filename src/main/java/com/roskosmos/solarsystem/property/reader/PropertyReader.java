package com.roskosmos.solarsystem.property.reader;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public Properties getProperties(String fileName) {

        Properties properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("property/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
