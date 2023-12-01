package ecom;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class AddProduct extends  BaseData{

    @Test
    public void addProduct(){
        File file = new File(System.getProperty("user.dir")+ "/Jeans.jpg" );
        RestAssured.baseURI="https://www.rahulshettyacademy.com";
        Response response = given()
                .header("authorization",token)
                .param("productName", "Jeans")

                .param("productAddedBy", userId)

                .param("productCategory", "fashion")

                .param("productSubCategory", "Trouser")

                .param("productPrice", "2000")

                .param("productDescription", "levis")

                .param("productFor", "Men")

                .multiPart("productImage",file)
                .when()
                .post("/api/ecom/product/add-product")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        productId = jsonPath.getString("productId");
        userId = jsonPath.getString("userId");

    }
}
