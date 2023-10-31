package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Task {

//    WAP to create the user and then fetch the value of user using GET request
//    https://petstore.swagger.io/#/user/getUserByName



    @Test
    public void createUsr(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response = given()
                .body("{\n" +
                        "  \"id\": 7,\n" +
                        "  \"username\": \"james\",\n" +
                        "  \"firstName\": \"james\",\n" +
                        "  \"lastName\": \"bond\",\n" +
                        "  \"email\": \"tttctfcffc@asdf.com\",\n" +
                        "  \"password\": \"bhbihbihbijji\",\n" +
                        "  \"phone\": \"007000470077\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when()
                .post("user")
                .then()
                .extract()
                .response();
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getUser(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response =  given()
                .when()
                .get("/user/james")
                .then()
                .extract()
                .response();

        System.out.println(response.asPrettyString());
    }
}
