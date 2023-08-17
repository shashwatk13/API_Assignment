package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static final String configFilePath = "C:\\Users\\Shashwat_Kawale\\OneDrive - Accscient Digital International Pvt Ltd\\Desktop\\API_Automation\\API_Automation\\src\\main\\resources\\Config\\BookerAPIConfig.properties";

    public static String baseURL = getConfigValue("baseURL");
    public static String generateTokenURL = getConfigValue("generateTokenURL");
    public static String getUrl = getConfigValue("getUrl");
    public static String postUrl = getConfigValue("postUrl");
    public static String putUrl = getConfigValue("putUrl");
    public static String deleteUrl = getConfigValue("deleteUrl");

    //Get the values from properties file
    public static String getConfigValue(String key)
    {
        String value = "";
        try {
            FileInputStream file = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(file);
            value = prop.getProperty(key);
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return value;
    }

}
