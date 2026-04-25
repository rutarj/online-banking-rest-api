package com.rutarj.onlinebankingrestapi.app.loa.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoaLoanEligibilityRequestDto {

    private Long customerId;
    private BigDecimal annualIncome;
    private Integer creditScore;
    private BigDecimal requestedAmount;
}
