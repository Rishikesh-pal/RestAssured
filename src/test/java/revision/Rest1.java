package revision;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Rest1 {
        @Test
    public void listUsers(){
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .extract().response();
        System.out.printf(response.asPrettyString());
        response.getStatusCode();
    }

    @Test
    public void singleUser(){
        baseURI = "https://reqres.in/";
        Response response = given().when()
                .get("/api/users/2")
                .then()
                .extract().response();
        System.out.printf(response.asPrettyString());
    }

    @Test
    public void postUser(){
        baseURI = "https://petstore.swagger.io/v2";
        Response response = given()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"babu-bhai\",\n" +
                        "  \"firstName\": \"William\",\n" +
                        "  \"lastName\": \"Allison\",\n" +
                        "  \"email\": \"ajleflajf@askjdbj.com\",\n" +
                        "  \"password\": \"jbfoda\",\n" +
                        "  \"phone\": \"7845+4651\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when()
                .post("/user")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());

    }

    @Test
    public void fetchUser(){
        baseURI = "https://petstore.swagger.io/v2";
        Response response = given()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"babu-bhai\",\n" +
                        "  \"firstName\": \"William\",\n" +
                        "  \"lastName\": \"Allison\",\n" +
                        "  \"email\": \"ajleflajf@askjdbj.com\",\n" +
                        "  \"password\": \"jbfoda\",\n" +
                        "  \"phone\": \"7845+4651\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when()
                .post("/user")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());


        response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/user/babu-bhai")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
    }

}
