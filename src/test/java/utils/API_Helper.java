package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Helper extends TestBase{

    //Request Specification
    public static RequestSpecification setRequestSpecification()
    {
        RequestSpecification reqspec = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .setBaseUri(BASE_URL)
                .build();
        return reqspec;
    }

    //Post Method
    public static Response postRequest(String url,RequestSpecification reqspec,String postBody){
        Response response = RestAssured.given()
                .spec(reqspec)
                .body(postBody)
                .post(url);
        return response;
    }

    //Get Method
    public static Response getRequest(String url,RequestSpecification reqspec){
        Response response = RestAssured.given()
                .spec(reqspec)
                .get(url);
        return response;
    }

    //Put Method
    public static Response putRequest(String accessToken,String url,RequestSpecification reqspec,String putBody){
        Response response = RestAssured.given()
                .spec(reqspec)
                .header("Cookie", "token="+accessToken)
                .body(putBody)
                .put(url);
        return response;
    }

    //Delete Method
    public static Response deleteRequest(String accessToken,String url,RequestSpecification reqspec){
        Response response = RestAssured.given()
                .spec(reqspec)
                .header("Cookie", "token="+accessToken)
                .get(url);
       return response;
    }

}
