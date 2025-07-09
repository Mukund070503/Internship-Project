package com.database_connection.mysqlConnection.serviceImpPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.database_connection.mysqlConnection.dbController.BaseController;
import com.database_connection.mysqlConnection.dbController.DbController;
import com.database_connection.mysqlConnection.repository.RuleInterface;
import com.database_connection.mysqlConnection.servicePackage.ServiceInterface;

import jakarta.servlet.http.HttpServletRequest;

import com.database_connection.mysqlConnection.entities.LimitRulesRequestDTO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.database_connection.mysqlConnection.serviceImpPackage.ServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ServiceImp implements ServiceInterface{
    private static final Logger logger = LoggerFactory.getLogger(DbController.class);
    @Autowired
    private RuleInterface limitRule;
    @Autowired
    private BaseController baseController;
    @Autowired
    private ObjectMapper objectMapper;
@Override
public ResponseEntity<Object> getAllRules() {
    Map<String, Object> response = new LinkedHashMap<>();
    List<Map<String, Object>> rulesList = new ArrayList<>();
    List<String> serviceIds = limitRule.getServiceId();

    // Define column names (Must match database column order in getData)
    String[] columnNames = {"RULE_ID", "KEY_TEMPLATE", "TIMEFRAME", "AMOUNT_LIMIT", "COUNT_LIMIT",
                            "START_DATETIME", "END_DATETIME", "PRECEDENCE", "ELIGIBILITY", "MIN_AMOUNT",
                            "MAX_AMOUNT", "STATUS", "RULE_CODE", "RULE_GROUP"};

    serviceIds.forEach(s -> {
        Map<String, Object> rules = new LinkedHashMap<>();
        rules.put("ServiceId", s);
        
        List<Object[]> ruleDataList = limitRule.getData(s);
        List<Map<String, Object>> formattedRules = new ArrayList<>();

        for (Object[] row : ruleDataList) {
            Map<String, Object> ruleMap = new LinkedHashMap<>();
            for (int i = 0; i < columnNames.length; i++) {
                ruleMap.put(columnNames[i], row[i]);
            }
            formattedRules.add(ruleMap);
        }

        rules.put("LimitRules", formattedRules);
        rulesList.add(rules);
    });

    response.put("meta", baseController.Success());
    response.put("data", rulesList);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

@Override
public ResponseEntity<Object> insertRule(LimitRulesRequestDTO limitrulesrequestdto) {
    if(limitRule.ruleCodeExists(limitrulesrequestdto.getRuleCode())==1L) {
        return new ResponseEntity<>(baseController.RuleCodeExists(), HttpStatus.OK);
    }
    
    limitRule.dataInserted(limitrulesrequestdto);
    
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("meta", baseController.SuccessMessage("Rule inserted successfully"));
    response.put("data", Map.of("isSuccessful", true));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

@Override
public ResponseEntity<Object> updateRule(LimitRulesRequestDTO limitrulesrequestdto) {

    if(limitRule.ruleIdExists(limitrulesrequestdto.getRuleId())==0L) {
        return new ResponseEntity<>(baseController.RuleNotFound("Rule doesn’t exist"), HttpStatus.OK);
    }


    limitRule.updateData(limitrulesrequestdto);
    
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("meta", baseController.SuccessMessage("Successfully Updated"));
    response.put("data", Map.of("isSuccessful", true));
    return new ResponseEntity<>(response, HttpStatus.OK);
}

@Override
public ResponseEntity<Object> deleteRule(LimitRulesRequestDTO limitrulesrequestdto) {

    if(limitRule.ruleIdExists(limitrulesrequestdto.getRuleId())==0L) {
        return new ResponseEntity<>(baseController.RuleNotFound("Rule doesn’t exist"), HttpStatus.OK);
    }

    limitRule.deleteRule(limitrulesrequestdto.getRuleId());
    
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("meta", baseController.SuccessMessage("Rule Deleted Successfully"));
    return new ResponseEntity<>(response, HttpStatus.OK);
}
@Override
public void loggerFunc(ResponseEntity<Object> response){
     ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = sra.getRequest();
        String requestType = req.getMethod();
        try {
            String json = objectMapper.writeValueAsString(response.getBody());
            logger.info("Response: " + json);  
        } catch (Exception e) {
            logger.error("Error converting to JSON", e);
        }
        logger.info("This is a {} request type.",requestType);
        logger.info("URL:{}",req.getRequestURI());
}
}
