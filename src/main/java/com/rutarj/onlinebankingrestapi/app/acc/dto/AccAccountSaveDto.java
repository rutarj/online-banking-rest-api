package com.rutarj.onlinebankingrestapi.app.acc.dto;

import com.rutarj.onlinebankingrestapi.app.acc.enums.AccAccountType;
import com.rutarj.onlinebankingrestapi.app.acc.enums.AccCurrencyType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccAccountSaveDto {

    private BigDecimal currentBalance;
    private AccCurrencyType currencyType;
    private AccAccountType accountType;
}
