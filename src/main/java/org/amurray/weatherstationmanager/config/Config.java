package org.amurray.weatherstationmanager.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Property file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            {
                throw new RuntimeException(e);
            }
        }
    }
        public static String get(String key) {
            return properties.getProperty(key);
        }
    }
