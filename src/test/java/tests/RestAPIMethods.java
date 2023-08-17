package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RestAPIMethods {

    //Request Specification
    public static RequestSpecification requestSpecification()
    {
        RequestSpecification reqspec = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .build();
        return reqspec;
    }

    //Post Method
    public static Response post(String url,RequestSpecification reqspec,String postBody){
        Response response = RestAssured.given()
                .spec(reqspec)
                .body(postBody)
                .post(url);
        return response;
    }

    //Get Method
    public static Response get(String url){
        Response response = RestAssured.given().get(url);
        return response;
    }

    //Put Method
    public static Response put(String accessToken,String url,RequestSpecification reqspec,String putBody){
        Response response = RestAssured.given()
                .spec(reqspec)
                .header("Cookie", "token="+accessToken)
                .body(putBody)
                .put(url);
        return response;
    }

    //Delete Method
    public static Response delete(String accessToken,String url,RequestSpecification reqspec){
        Response response = RestAssured.given()
                .spec(reqspec)
                .header("Cookie", "token="+accessToken)
                .get(url);
       return response;
    }

}
