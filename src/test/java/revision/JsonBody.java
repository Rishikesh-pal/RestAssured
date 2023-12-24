package revision;

public class JsonBody {

    public static String getBody(){
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"James.Bond\",\n" +
                "  \"firstName\": \"Bond\",\n" +
                "  \"lastName\": \"Bond\",\n" +
                "  \"email\": \"James.Bond@gmm.com\",\n" +
                "  \"password\": \"qwerty\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        return body;
    }
}
