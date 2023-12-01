package ecom;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AppLogin extends BaseData{

    @Test
    public void login(){
        RestAssured.baseURI="https://www.rahulshettyacademy.com";
        Response response = given()
                .body("{\n" +
                        "    \"userEmail\": \"dohege8067@eazenity.com\",\n" +
                        "     \"userPassword\": \"Qwerty@1234\"\n" +
                        "}")
                .header("Content-Type","application/json")
                .when()
                .post("/api/ecom/auth/login")
                .then()
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        token = jsonPath.getString("token");
        userId = jsonPath.getString("userId");

    }

}
