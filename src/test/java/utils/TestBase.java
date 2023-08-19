package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class TestBase extends ConfigReader {

    private static Logger log = LogManager.getLogger(TestBase.class);

    public static String ACCESS_TOKEN = "";
    public static String BASE_URL;
    public static String GENERATE_TOKEN_URL;
    public static String GET_URL;
    public static String POST_URL;
    public static String PUT_URL;
    public static String DELETE_URL;

    @BeforeTest
    public static void initialSetup()
    {
        readConfigValue();
        readAndAssignConfigValues();
        createToken();
    }

    public static void createToken(){
        ACCESS_TOKEN = GenerateBearerToken.getBearerToken("GenerateTokenBody");
        readConfigValue();
        if(!ACCESS_TOKEN.equals(""))
        {
            System.out.println("Successfully generated the access token : "+ACCESS_TOKEN);
        }else
        {
            Assert.fail("Unable to generate access token");
        }
    }

    public static void readAndAssignConfigValues(){
        BASE_URL = getConfigValue("baseURL");
        GENERATE_TOKEN_URL = getConfigValue("generateTokenURL");
        GET_URL= getConfigValue("getUrl");
        POST_URL = getConfigValue("postUrl");
        PUT_URL = getConfigValue("putUrl");
        DELETE_URL = getConfigValue("deleteUrl");
    }
}
