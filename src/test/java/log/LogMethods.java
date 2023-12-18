package log;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogMethods {

    @Test
    public void fetchUser(){
        RestAssured.baseURI = "https://reqres.in/";
        given()
                .when()
                .log().ifValidationFails()
                .get("/api/users?page=2/tyfggvgvvhhhihy")
                .then()
                .log().ifError()

              ;


    }
}
