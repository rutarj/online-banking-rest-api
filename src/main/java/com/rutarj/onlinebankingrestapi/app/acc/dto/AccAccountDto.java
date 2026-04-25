package com.rutarj.onlinebankingrestapi.app.acc.dto;

import com.rutarj.onlinebankingrestapi.app.acc.enums.AccAccountType;
import com.rutarj.onlinebankingrestapi.app.acc.enums.AccCurrencyType;
import com.rutarj.onlinebankingrestapi.app.gen.enums.GenStatusType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccAccountDto {

    private Long id;
    private Long customerId;
    private String ibanNo;
    private BigDecimal currentBalance;
    private AccCurrencyType currencyType;
    private AccAccountType accountType;
    private GenStatusType statusType;
}