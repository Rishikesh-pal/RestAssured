package revision.specbuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static java.lang.Math.log;

public class SpecsTests {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void initRequestAndResponseSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
        requestSpecBuilder.addHeader("Content-Type", "application/json");
//        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
//        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectStatusCode(200);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void postUser(){
        baseURI = "https://petstore.swagger.com/v2";
        given()
                .spec(requestSpecification)
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
//                .log().ifValidationFails()
                .log().all()
                .when()
                .post("/user")
                .then()
//                .statusCode(300)
//                .log().ifStatusCodeIsEqualTo(200)
                .log().ifError()
        ;
    }
}
