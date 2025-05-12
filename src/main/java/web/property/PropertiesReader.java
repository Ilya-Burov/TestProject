package web.property;


import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesReader {

    private static Properties properties;
    private static PropertiesReader instance;
    private static String propsFileName;

    private PropertiesReader() {
    }

    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    protected static String getPropertyValue(String name, String propertiesFileName) {
        if (System.getProperty(name) != null) {
            return System.getProperty(name);
        }
        return getInstance().getValueFromConfigFile(name, propertiesFileName);
    }

    private String getValueFromConfigFile(String key, String propertiesFileName) {
        if (properties == null || !propsFileName.equals(propertiesFileName)) {
            properties = loadConfigFile(propertiesFileName);
            propsFileName = propertiesFileName;
        }

        Object objFromFile = properties.getProperty(key);
        if (objFromFile != null) {
            return Objects.toString(objFromFile);
        } else {
            return null;
        }
    }

    private Properties loadConfigFile(String propertiesFileName) {
        try {
            Properties prop = new Properties();
            prop.load(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(propertiesFileName)));
            return prop;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}