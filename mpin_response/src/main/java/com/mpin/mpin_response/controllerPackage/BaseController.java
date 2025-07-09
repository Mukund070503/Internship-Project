package com.mpin.mpin_response.controllerPackage;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class BaseController {

    public Map<String, Object> Success(){
        Map<String, Object> meta = new LinkedHashMap<>(); 
        meta.put("code", "000");
        meta.put("description", "SUCCESS");
        meta.put("status", 0);
        return meta;
    }

    public Map<String, Object> Failure(){
        Map<String, Object> meta = new LinkedHashMap<>(); 
        meta.put("code", "001");
        meta.put("description", "Fail");
        meta.put("status", 1);
        return meta;
    }
    
    public Map<String, Object> TeamExists(){
        Map<String, Object> meta = new LinkedHashMap<>();
        meta.put("code", "1045");
        meta.put("description", "Team Already exists");
        meta.put("status", 1);
        return meta;
    }

    public Map<String, Object> TeamNotFound(String message){
        Map<String, Object> meta = new LinkedHashMap<>();
        meta.put("code", "101");
        meta.put("description", message);
        meta.put("status", 1);
        return meta;
    }

    public Map<String, Object> SuccessMessage(String message){
        Map<String, Object> meta = new LinkedHashMap<>();
        meta.put("code", "000");
        meta.put("description", message);
        meta.put("status", 0);
        return meta;
    }

    public Map<String, Object> FailureMessage(String message){
        Map<String, Object> meta = new LinkedHashMap<>();
        meta.put("code", "001");
        meta.put("description", message);
        meta.put("status", 1);
        return meta;
    }
}
