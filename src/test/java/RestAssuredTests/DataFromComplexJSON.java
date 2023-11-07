package RestAssuredTests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DataFromComplexJSON {
    //Fetching the data from complex json:

    @Test
    public void test(){
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getInt("data[0].id"));
        System.out.println(jsonPath.getString("data[0].last_name"));
        int arraySize = jsonPath.getInt("data.size()");

        System.out.println(arraySize);//6

    }


    @Test
    public void task1(){
        /*
        WAP to print the lastname of person whose id is 10
        WAP to print all the email address of all index positions

         */

        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        int arraySize = jsonPath.getInt("data.size()"); // --> groovy script run in background
        for (int i=0; i<arraySize;i++){
//           if (jsonPath.getInt("data["+i+"].id") == 10){
//               System.out.println(jsonPath.getString("data["+i+"].last_name"));
//           }
            System.out.println(jsonPath.getString("data["+i+"].email"));
        }


//        jsonPath.getObject("data["+i+"].id")


    }
}
