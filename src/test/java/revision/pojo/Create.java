package revision.pojo;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class Create {


    @Test
    public void createUser(){
        RequestSample requestSample = new RequestSample();
        requestSample.setId(0);
        requestSample.setEmail("hiksdghikdc@skdghsdh.com");
        requestSample.setFirstName("josh");
        requestSample.setLastName("wilson");
        requestSample.setPassword("78378357831783");
        requestSample.setPhone("0897677");
        requestSample.setUserStatus(0);
        baseURI  = "https://petstore.swagger.io/v2";
        ResponseSample responseSample =  given()
                .body(requestSample)
                .header("Content-Type", "application/json")
                .when()
                .post("/user")
                .then()
                .extract().response().as(ResponseSample.class);
        System.out.println(responseSample.getCode());
    }

}
