package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class APITestPUT {

    @Test
    public void testPutRequest() {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("id", 8);
        requestMap.put("name", "15_pro");
        /*requestMap.put("title", "foo");
        requestMap.put("completed", true);*/

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestMap)
                .put("https://api.restful-api.dev/objects/7");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String title = response.jsonPath().getString("title");
        //Assert.assertEquals(title, "null");
        System.out.println("Body : "+response.getBody().asString());
    }
}
