package ecom;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Deleteproduct extends BaseData{

    @Test
    public void delete(){
        RestAssured.baseURI = "https://www.rahulshettyacademy.com";

        given()
                .header("Authorization", token)
                .pathParam("productId",productId)
                .log().all()
                .when()
                .delete("/api/ecom/product/delete-product/{productId}")
                .then()
                .log().all();
    }
}
