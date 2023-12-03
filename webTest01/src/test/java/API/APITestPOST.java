package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class APITestPOST {

    @Test
    public void testPostRequest() {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", "testPOST");
        requestMap.put("data", "data1");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestMap)
                .post("https://api.restful-api.dev/objects");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println(response.statusCode());
        System.out.println("Body : "+response.getBody().asString());
    }
}
