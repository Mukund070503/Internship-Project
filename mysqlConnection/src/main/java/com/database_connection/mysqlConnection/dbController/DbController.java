package com.database_connection.mysqlConnection.dbController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.database_connection.mysqlConnection.entities.LimitRulesRequestDTO;
import com.database_connection.mysqlConnection.serviceImpPackage.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api/v1/limit-config")
public class DbController {

    @Autowired
    private ServiceImp rule;

    @GetMapping("/get-rules")
    public ResponseEntity<Object> getAllRules() {
        ResponseEntity<Object> response = rule.getAllRules();  
        rule.loggerFunc(response);
        return response;
    }
    @PostMapping("/add-rule")
    public ResponseEntity<Object> insertRule(@RequestBody LimitRulesRequestDTO limitrulesrequestdto) {
        ResponseEntity<Object> response = rule.insertRule(limitrulesrequestdto);  
        rule.loggerFunc(response);
        return response;
    }
    @PostMapping("/update-rule")
    public ResponseEntity<Object> updateRule(@RequestBody LimitRulesRequestDTO limitrulesrequestdto){
        ResponseEntity<Object> response = rule.updateRule(limitrulesrequestdto);  
        rule.loggerFunc(response);
        return response;
    }
    @PostMapping("/remove-rule")
    public ResponseEntity<Object> deleteRule(@RequestBody LimitRulesRequestDTO limitrulesrequestdto){
        ResponseEntity<Object> response = rule.deleteRule(limitrulesrequestdto);  
        rule.loggerFunc(response);
        return response;
    }
}
