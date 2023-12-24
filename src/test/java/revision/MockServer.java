package revision;

import groovy.xml.StreamingDOMBuilder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.*;
import java.util.Map;

public class MockServer {
    //{
    //    "id": "0001",
    //    "type": "donut",
    //    "name": "Cake",
    //    "ppu": 0.55,
    //    "batters":
    //        {
    //          "batter"  :
    //                [
    //                    { "id": "1001", "type": "Regular" },
    //                    { "id": [
    //                      5, 9
    //                    ], "type": "Chocolate" }
    //                ]
    //        },
    //    "topping":
    //        [
    //            { "id": "5001", "type": "None" },
    //            { "id": "5002", "type": "Glazed" },
    //            { "id": "5005", "type": "Sugar" }
    //
    //        ]}
    @Test
    public void ans(){
        List<Object> id = new ArrayList<>();
        id.add(4);
        id.add(9);
        HashMap<Object,Object> batter1 = new HashMap<>();
        batter1.put("id","1001");
        batter1.put("type","Regular");
        HashMap<Object,Object> batter2 = new HashMap<>();
        batter2.put("id", id);
        batter2.put("type", "Chocolate" );
        List<Object> batter = new ArrayList<>();
        batter.add(batter1);
        batter.add(batter2);

        HashMap<Object,Object> topping1 = new HashMap<>();
        topping1.put("id", "5001");
        topping1.put("type", "None");
        HashMap<Object,Object> topping2 = new HashMap<>();
        topping2.put("id","5002");
        topping2.put("type", "Glazed");
        HashMap<Object,Object> topping3 = new HashMap<>();
        topping3.put("id","5005");
        topping3.put("type","Sugar");
        List<Object> topping = new ArrayList<>();
        topping.add(topping1);
        topping.add(topping2);
        topping.add(topping3);


        HashMap<Object, Object> main = new HashMap<>();
        main.put("id", "0001");
        main.put("type", "donut");
        main.put("name", "Cake");
        main.put("ppu", 0.55);
        main.put("batter",batter);
        main.put("topping",topping);


        baseURI = "https://a02187b2-75ef-49bf-a23d-a45a6a7ac83e.mock.pstmn.io/task";
        given().body(main)
                .header("Content-Type","application/json")
                .log().all()
                .when()
                .post()
                .then()
                .log().all();
    }
}
