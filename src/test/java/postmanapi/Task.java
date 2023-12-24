package postmanapi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task {

     //WAP to fetch the information using this request:
    //https://api.getpostman.com/workspaces/{{workspaceId}}

//    @Test
//    public void task1(){
//        Test12.baseURI = "https://api.getpostman.com";
//        Response response=given()
//                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
//                .when()
//                .get("/workspaces/04fd5610-5655-4be4-8b96-829ee0448fdd")
//                .then()
//                .extract()
//                .response();
//        System.out.println(response.asPrettyString());
//    }

//    WAP to create the user and verify the value of id using Get method:
//    https://petstore.swagger.io/#/user/createUser

    String id_post;
    String username = "james";
    @Test(priority = 0)
    public void task2_post(){
        baseURI = "https://petstore.swagger.io/v2";
        Response response = given()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \" "+ username +"\",\n" +
                        "  \"firstName\": \"james\",\n" +
                        "  \"lastName\": \"bond\",\n" +
                        "  \"email\": \"tttctfcffc@asdf.com\",\n" +
                        "  \"password\": \"bhbihbihbijji\",\n" +
                        "  \"phone\": \"007000470077\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .header("Content-Type","application/json")
                .post("user")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        id_post = jsonPath.getString("message");
        System.out.println(id_post);
    }

    @Test(priority = 1)
    public void tas2_get(){
        baseURI = "https://petstore.swagger.io/v2";
        Response response= given()
                .header("Content-Type","application/json")
                .when()
                .get("/user/"+username)
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("message"),id_post);
    }
}
