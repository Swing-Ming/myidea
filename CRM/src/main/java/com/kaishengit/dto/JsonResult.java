package com.kaishengit.dto;

public class JsonResult {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";


    private String message;
    private String state;
    private Object data;

    public JsonResult(Object data){

        this(SUCCESS,data);
    }

    public JsonResult(String message){
        this(ERROR,message);
    }

    public JsonResult(String state,Object data){
        this.data = data;
        this.state = state;
    }
    public JsonResult(String state, String message ){
        this.state = state;
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
