package utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

    public static String jsonFileContent = "";
    public static JsonObject jsonBody;

    public static String body = "";

    public static String readFilePath(String jsonFileName)
    {
        try {
            return jsonFileContent = new String(Files.readAllBytes(Paths.get("C:\\Users\\Shashwat_Kawale\\OneDrive - Accscient Digital International Pvt Ltd\\Desktop\\API_Automation\\API_Automation\\src\\main\\resources\\JSON\\"+jsonFileName+".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String jsonDataParse(String jsonFileName)
    {
        readFilePath(jsonFileName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        jsonBody = gson.fromJson(jsonFileContent, JsonObject.class);
        body = jsonBody.toString();
        return body;
    }
}
