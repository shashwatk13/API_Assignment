package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.*;

@Listeners(utils.Listeners.class)
public class Test_Booker extends TestBase {

    private static Logger log = LogManager.getLogger(Test_Booker.class);

    @Test(priority = 1,description = "Create new booking")
    public void createBooking()
    {
        String postBody = JsonReader.jsonDataParse("CreateBookingBody");
        //Post method call
        Response postResponse = API_Helper.postRequest(POST_URL, API_Helper.setRequestSpecification(),postBody);
        log.info("Create Booking :: \n"+postResponse.prettyPrint());


        //Response code validation
        Assert.assertEquals(postResponse.getStatusCode(),200);
        //Assertion to check booking id has generated or not
        String body = postResponse.getBody().asString();
        Assert.assertTrue(body.contains("bookingid"),"Booking id not generated");
    }

    @Test(priority = 2,description = "Get booking details")
    public void getBooking(){
        //Get method call
        Response response = API_Helper.getRequest(GET_URL, API_Helper.setRequestSpecification());
        System.out.println("Booking details :: \n"+response.prettyPrint());

        //Response code validation
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3,description = "Update the booking details")
    public void updateBooking(){
        String putBody = JsonReader.jsonDataParse("UpdateBookingBody");
        //Put method call
        Response putResponse = API_Helper.putRequest(ACCESS_TOKEN,PUT_URL, API_Helper.setRequestSpecification(),putBody);
        System.out.println("Updated Booking Details :: \n"+putResponse.prettyPrint());

        //Response code validation
        Assert.assertEquals(putResponse.getStatusCode(),200);
    }

    @Test(priority = 4,description = "Delete booking")
    public void deleteBooking(){
        //Delete method call
        Response deleteResponse = API_Helper.deleteRequest(ACCESS_TOKEN,DELETE_URL, API_Helper.setRequestSpecification());

        //Response code validation
        Assert.assertEquals(deleteResponse.getStatusCode(),200);
    }


}
