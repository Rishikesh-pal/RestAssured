package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class GetMethod {

    @Test
    public void fetchUser(){
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .extract()
                .response();

        System.out.println(response.asPrettyString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);
        System.out.println(response.getTime());
    }
}
