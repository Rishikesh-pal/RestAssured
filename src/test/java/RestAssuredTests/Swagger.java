package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Swagger {

    public static String jsonBody(){
        String json = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"James\",\n" +
                "  \"firstName\": \"Bond\",\n" +
                "  \"lastName\": \"bond\",\n" +
                "  \"email\": \"james.bond@qwerty.in\",\n" +
                "  \"password\": \"james123\",\n" +
                "  \"phone\": \"9639639639\",\n" +
                "  \"userStatus\": 0\n";

        return json;
    }

    @Test
    public void createUser(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response = given()
                .body(Swagger.jsonBody())
                .header("Content-Type", "application/json")
                .when()
                .post("/user")
                .then()
                .extract()
                .response();
        System.out.println(response.asPrettyString());

    }

    @Test
    public void createUserUsingMap() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        HashMap<String , Object> hashMap = new HashMap<>();
        hashMap.put("id",0);
        hashMap.put("username","james");
        hashMap.put("lastname","bond");
        hashMap.put("email", "java.user@gmail.com");
        hashMap.put("password", "Test@1234");
        hashMap.put("phone", "9876543211");
        hashMap.put("userStatus", 0);

        given().body(hashMap)
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .post("/user")
                .then()
                .log().all();

    }




}
