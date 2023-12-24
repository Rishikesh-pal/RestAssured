package revision.specbuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class RequestAndResponseSpecBuilder {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void initRequestAndResponseSpec(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectStatusCode(200);
        responseSpecification = responseSpecBuilder.build();
    }
}
