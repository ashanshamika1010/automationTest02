package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestDELETE {

    @Test
    public void testDeleteRequest() {
        Response response = RestAssured.delete("https://api.restful-api.dev/objects/6");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}

