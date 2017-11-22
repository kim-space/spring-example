package com.kimtd.common;

import org.springframework.ui.ModelMap;


public class RestResponse {

    private int code;
    private String message;
    private ModelMap content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelMap getContent() {
        return content;
    }

    public void setContent(ModelMap content) {
        this.content = content;
    }

    public static RestResponse success(ModelMap modelMap){
        RestResponse response = new RestResponse();
        response.setCode(0);
        response.setMessage("success");
        response.setContent(modelMap);
        return response;
    }

    public static RestResponse error(String message){
        RestResponse response = new RestResponse();
        response.setCode(-1);
        response.setMessage(message);
        return response;
    }
}
