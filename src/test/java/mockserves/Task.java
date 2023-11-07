package mockserves;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Task {

   @Test
    public void task(){
       List<Object> id = new ArrayList<Object>();
       id.add(5);
       id.add(9);

       HashMap<Object,Object> inner1 = new HashMap<>();
       inner1.put("id","1001");
       inner1.put("type","Regular");

      HashMap<Object,Object> inner2 = new HashMap<Object,Object>();
      inner2.put("id",id);
      inner2.put("type","Chocolate");

      List<HashMap<Object,Object>> batter = new ArrayList<HashMap<Object,Object>>();
      batter.add(inner1);
      batter.add(inner2);

      HashMap<Object,Object> batter1 = new HashMap<Object,Object>();
      batter1.put("batter",batter);

      HashMap<Object,Object> topping1 = new HashMap<>();
      topping1.put("id","5001");
      topping1.put("type","None");

      HashMap<Object,Object> topping2 = new HashMap<>();
      topping2.put("id","5002");
      topping2.put("type","Glazed");

      HashMap<Object,Object> topping3= new HashMap<>();
      topping3.put("id","5005");
      topping3.put("type","Sugar");

      List<HashMap<Object,Object>> topping = new ArrayList<HashMap<Object,Object>>();
      topping.add(topping1);
      topping.add(topping2);
      topping.add(topping3);

      HashMap<Object,Object> main = new HashMap<Object,Object>();
      main.put("id","0001");
      main.put("type","donut");
      main.put("name","Cake");
      main.put("ppu",0.55);
      main.put("batters",batter1);
      main.put("topping",topping);

      RestAssured.baseURI = "https://a02187b2-75ef-49bf-a23d-a45a6a7ac83e.mock.pstmn.io";




      given()

              .body(main)

              .header("Content-Type", "application/json")

              .header("x-mock-match-request-body", "true")

              .log().all()

              .when()

              .post("/task")

              .then()

              .log().all()

              .extract()

              .response();

   }







}
