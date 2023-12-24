package revision.pojo;

public class ResponseSample {

    Integer code;
    String type;
    String message;

    public Integer setCode(Integer code){
        return this.code = code;
    }

    public Integer getCode(){
        return code;
    }

    public String setType(String type){
        return this.type=type;
    }

    public String getType(){
        return type;
    }

    public String setMessage(String message){
        return this.message=message;
    }

    public String getMessage(){
        return message;
    }

}
