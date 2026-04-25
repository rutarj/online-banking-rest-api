package com.rutarj.onlinebankingrestapi.app.crd.dto;

import com.rutarj.onlinebankingrestapi.app.crd.enums.CrdCreditCardActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CrdCreditCardActivityAnalysisDto {

    private CrdCreditCardActivityType activityType;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Double avgAmount;
    private Long activityCount;
}
