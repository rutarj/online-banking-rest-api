package com.rutarj.onlinebankingrestapi.app.loa.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoaLoanEligibilityResponseDto {

    private Boolean eligible;
    private BigDecimal maxAmount;
    private BigDecimal interestRate;
    private String reason;
}
