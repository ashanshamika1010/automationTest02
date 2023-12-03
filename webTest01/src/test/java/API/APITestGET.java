package API;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APITestGET {
    //1st way
    @Test
    void test01() throws Exception{

        Response response =  get("https://api.restful-api.dev/objects");

        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time Taken : "+response.getTime());
        System.out.println("Header : "+response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

    //2nd way
    @Test
    void test02(){
        given().get("https://api.restful-api.dev/objects").then().statusCode(200);

    }
}
