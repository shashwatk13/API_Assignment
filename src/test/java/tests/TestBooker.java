package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.GenerateBearerToken;
import utils.JsonReader;

public class TestBooker extends ConfigReader {

    String accessToken = "";

    @BeforeClass(description = "Generate access token")
    public void createToken(){
        accessToken = GenerateBearerToken.getBearerToken("GenerateTokenBody");
        if(!accessToken.equals(""))
        {
            System.out.println("Successfully generated the access token : "+accessToken);
        }else
        {
            Assert.fail("Unable to generate access token");
        }
    }

    @Test(priority = 1,description = "Create new booking")
    public void createBooking()
    {
        String postBody = JsonReader.jsonDataParse("CreateBookingBody");
        //Post method call
        Response postResponse = RestAPIMethods.post(baseURL+postUrl,RestAPIMethods.requestSpecification(),postBody);
        System.out.println("Create Booking:: ");
        postResponse.prettyPrint();

        //Response code validation
        Assert.assertEquals(postResponse.getStatusCode(),200);
        //Assertion to check booking id has generated or not
        String body = postResponse.getBody().asString();
        Assert.assertTrue(body.contains("bookingid"),"Booking id not generated");
    }

    @Test(priority = 2,description = "Get booking details")
    public void getBooking(){
        //Get method call
        Response response = RestAPIMethods.get(baseURL+getUrl);
        System.out.println("Booking details : ");
        response.prettyPrint();
        //Response code validation
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3,description = "Update the booking details")
    public void updateBooking(){
        String putBody = JsonReader.jsonDataParse("UpdateBookingBody");
        //Put method call
        Response putResponse = RestAPIMethods.put(accessToken,baseURL+putUrl,RestAPIMethods.requestSpecification(),putBody);
        System.out.println("Updated Booking Details : ");
        putResponse.prettyPrint();

        //Response code validation
        Assert.assertEquals(putResponse.getStatusCode(),200);
    }

    @Test(priority = 4,description = "Delete booking")
    public void deleteBooking(){
        //Delete method call
        Response deleteResponse = RestAPIMethods.delete(accessToken,baseURL+deleteUrl,RestAPIMethods.requestSpecification());

        //Response code validation
        Assert.assertEquals(deleteResponse.getStatusCode(),200);
    }


}
