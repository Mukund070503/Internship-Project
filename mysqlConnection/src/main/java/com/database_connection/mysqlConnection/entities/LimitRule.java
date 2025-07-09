package com.database_connection.mysqlConnection.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "LIMIT_RULES")
public class LimitRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RULE_ID")
    private Integer ruleId;

    @Column(name = "SERVICE_ID", nullable = false)
    private String serviceId;

    @Column(name = "KEY_TEMPLATE", nullable = false)
    private String keyTemplate;

    @Column(name = "TIMEFRAME", nullable = false)
    private String timeFrame;

    @Column(name = "AMOUNT_LIMIT")
    private BigDecimal amountLimit;

    @Column(name = "COUNT_LIMIT")
    private Integer countLimit;

    @Column(name = "START_DATETIME", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "END_DATETIME")
    private LocalDateTime endDateTime;

    @Column(name = "PRECEDENCE", nullable = false)
    private Integer precedence;

    @Column(name = "ELIGIBILITY", nullable = false)
    private String eligibility;

    @Column(name = "MIN_AMOUNT")
    private BigDecimal minAmount;

    @Column(name = "MAX_AMOUNT")
    private BigDecimal maxAmount;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "RULE_CODE", nullable = false)
    private String ruleCode;

    @Column(name = "RULE_GROUP")
    private String ruleGroup;

}
