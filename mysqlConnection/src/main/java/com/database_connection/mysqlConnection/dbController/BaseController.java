package com.database_connection.mysqlConnection.dbController;

import java.util.Map;
import java.util.LinkedHashMap;
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
    
    public Map<String, Object> RuleCodeExists(){
        Map<String, Object> meta = new LinkedHashMap<>();
        meta.put("code", "1045");
        meta.put("description", "RuleCode Already exists");
        meta.put("status", 1);
        return meta;
    }

    public Map<String, Object> RuleNotFound(String message){
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
