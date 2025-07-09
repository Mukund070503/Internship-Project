package com.database_connection.mysqlConnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.database_connection.mysqlConnection.entities.LimitRule;
import com.database_connection.mysqlConnection.entities.LimitRulesRequestDTO;
@Repository
public interface RuleInterface extends JpaRepository <LimitRule, Integer>{

    @Query(value = "SELECT DISTINCT SERVICE_ID FROM LIMIT_RULES", nativeQuery = true)
    public List<String> getServiceId();
    
    @Query(value = "Select RULE_ID,KEY_TEMPLATE,TIMEFRAME,AMOUNT_LIMIT,COUNT_LIMIT,START_DATETIME,END_DATETIME,PRECEDENCE,ELIGIBILITY,MIN_AMOUNT,MAX_AMOUNT,STATUS,RULE_CODE,RULE_GROUP FROM LIMIT_RULES WHERE SERVICE_ID=:serviceId",nativeQuery = true)
    public List<Object[]> getData(String serviceId);
                                                                                                                                                                                                                                            
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO LIMIT_RULES (SERVICE_ID, KEY_TEMPLATE, TIMEFRAME, AMOUNT_LIMIT, COUNT_LIMIT, START_DATETIME, END_DATETIME, PRECEDENCE, ELIGIBILITY, MIN_AMOUNT, MAX_AMOUNT, STATUS, RULE_CODE, RULE_GROUP) VALUES (:#{#dto.serviceId}, :#{#dto.keyTemplate}, :#{#dto.timeFrame}, :#{#dto.amountLimit}, :#{#dto.countLimit}, :#{#dto.startDateTime}, :#{#dto.endDateTime}, :#{#dto.precedence}, :#{#dto.eligibility}, :#{#dto.minAmount}, :#{#dto.maxAmount}, :#{#dto.status}, :#{#dto.ruleCode}, :#{#dto.ruleGroup})", nativeQuery = true)
    void dataInserted(@Param("dto") LimitRulesRequestDTO dto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE LIMIT_RULES SET SERVICE_ID = :#{#dto.serviceId}, KEY_TEMPLATE = :#{#dto.keyTemplate}, TIMEFRAME = :#{#dto.timeFrame}, AMOUNT_LIMIT = :#{#dto.amountLimit}, COUNT_LIMIT = :#{#dto.countLimit}, START_DATETIME = :#{#dto.startDateTime}, END_DATETIME = :#{#dto.endDateTime}, PRECEDENCE = :#{#dto.precedence}, ELIGIBILITY = :#{#dto.eligibility}, MIN_AMOUNT = :#{#dto.minAmount}, MAX_AMOUNT = :#{#dto.maxAmount}, STATUS = :#{#dto.status}, RULE_CODE = :#{#dto.ruleCode}, RULE_GROUP = :#{#dto.ruleGroup} WHERE RULE_ID = :#{#dto.ruleId}", nativeQuery = true)
    public void updateData(@Param("dto") LimitRulesRequestDTO dto);
    

    @Modifying
    @Transactional
    @Query(value ="DELETE FROM LIMIT_RULES WHERE RULE_ID =:ruleId" ,nativeQuery = true)
    public void deleteRule( 
    Integer ruleId);

    @Query(value = "SELECT COUNT(RULE_ID) FROM LIMIT_RULES WHERE RULE_CODE = :ruleCode", nativeQuery = true)
    public long ruleCodeExists(String ruleCode);
    
    @Query(value = "SELECT COUNT(RULE_ID) FROM LIMIT_RULES WHERE RULE_ID = :ruleId", nativeQuery = true)
    public long ruleIdExists(Integer ruleId);
}

