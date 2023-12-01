package serailization;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.CreateRequestBody;
import pojo.CreateResponseBody;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void createUser()
    {
        CreateRequestBody cs = new CreateRequestBody();
        cs.setId(0);
        cs.setUsername("Restuser1");
        cs.setFirstName("RestAssured1");
        cs.setLastName("API1");
        cs.setEmail("res1t@rest.com");
        cs.setPassword("Test@1234");
        cs.setPhone("9876543211");
        cs.setUserStatus(0);


        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        CreateResponseBody createResponseBody = given()

                .body(cs)

                .header("Content-Type", "application/json")

                .when()

                .post("user")

                .then()

                .extract()

                .response()

                .as(CreateResponseBody.class);


        String message = createResponseBody.getMessage();

        System.out.println(message);


        Integer stsCode = createResponseBody.getCode();

        System.out.println(stsCode);

    }





}
