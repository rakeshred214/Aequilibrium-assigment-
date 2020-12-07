package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    static String configFile="config.properties";
    public static String getProperty(String propertyValue)  {
        Properties properties = new Properties();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream(configFile);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyValue);
    }
}