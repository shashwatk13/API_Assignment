package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GenerateBearerToken extends ConfigReader{

    public static String TOKEN = "";

    public static String getBearerToken(String jsonFileName)
    {
        String body = JsonReader.jsonDataParse(jsonFileName);
        Response response = RestAssured.given()
                            .header("Content-Type","application/json")
                            .body(body)
                            .post(baseURL+generateTokenURL);

        TOKEN = response.jsonPath().get("token");
        return TOKEN;
    }

}
