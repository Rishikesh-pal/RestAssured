package serailization;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.GetUserBody;

import static io.restassured.RestAssured.given;

public class GetUserDetail {

    @Test
    public void fetchingUserDetails() {
        RestAssured.baseURI = "https://reqres.in";

        GetUserBody resp = given()

                .when()

                .get("api/users?page=2")

                .then()

                .extract()

                .response()

                .as(GetUserBody.class);


        int totalValue = resp.getTotal();
        System.out.println(totalValue);//12

//	Assignment: WAP to print the lastname of second index position's user.

        System.out.println(resp.getData().get(2).getLast_name());


    }
}
