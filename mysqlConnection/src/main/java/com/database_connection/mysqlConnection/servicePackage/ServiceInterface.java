package com.database_connection.mysqlConnection.servicePackage;

import org.springframework.http.ResponseEntity;
import com.database_connection.mysqlConnection.entities.LimitRulesRequestDTO;

public interface ServiceInterface {
    ResponseEntity<Object> getAllRules();
    ResponseEntity<Object> insertRule(LimitRulesRequestDTO limitrulesrequestdto);
    ResponseEntity<Object> updateRule(LimitRulesRequestDTO limitrulesrequestdto);
    ResponseEntity<Object> deleteRule(LimitRulesRequestDTO limitrulesrequestdto);
    public void loggerFunc(ResponseEntity<Object> response);
}
