package com.example.library.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static Properties properties;
    
    static {
        properties = new Properties();
        try {
            InputStream inputStream = PropertiesLoader.class.getClassLoader()
                    .getResourceAsStream("application.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}

