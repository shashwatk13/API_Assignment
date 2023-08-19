package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    //Get the values from properties file
    public static String getConfigValue(String key)
    {
        return prop.getProperty(key);
    }

    public static void readConfigValue(){
        String configFilePath = "src/main/resources/Config/BookerAPIConfig.properties";
        String value = "";
        try {
            FileInputStream file = new FileInputStream(configFilePath);
            prop = new Properties();
            prop.load(file);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
