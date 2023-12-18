package specification;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestResponse {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void initRequestSpecification(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
        requestSpecBuilder.addParam("Content-Type", "application/json");
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
        responseSpecBuilder
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void createUser(){
        given(requestSpecification)
//                .spec(requestSpecification)
                .body("{\r\n"
                        + "  \"id\": 0,\r\n"
                        + "  \"username\": \"fridayuser\",\r\n"
                        + "  \"firstName\": \"friday\",\r\n"
                        + "  \"lastName\": \"October\",\r\n"
                        + "  \"email\": \"automationtest@test.com\",\r\n"
                        + "  \"password\": \"Test@1234\",\r\n"
                        + "  \"phone\": \"9876543213\",\r\n"
                        + "  \"userStatus\": 0\r\n"
                        + "}")
                .when()
                .post("/user")
                .then()
                .spec(responseSpecification);
    }
}
