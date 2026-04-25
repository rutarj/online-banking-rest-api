package com.rutarj.onlinebankingrestapi.app.loa.dto;

import com.rutarj.onlinebankingrestapi.app.loa.enums.LoaLoanStatusType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoaPayLoanOffResponseDto {
    private Long id;
    private Long customerId;
    private BigDecimal paidAmount;
    private BigDecimal remainingAmount;
    private LoaLoanStatusType loanStatusType;
}
