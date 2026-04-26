package com.rutarj.onlinebankingrestapi.app.loa.service;

import com.rutarj.onlinebankingrestapi.app.loa.dto.LoaLoanEligibilityRequestDto;
import com.rutarj.onlinebankingrestapi.app.loa.dto.LoaLoanEligibilityResponseDto;
import com.rutarj.onlinebankingrestapi.app.loa.service.entityservice.LoaLoanEntityService;
import com.rutarj.onlinebankingrestapi.app.loa.service.entityservice.LoaLoanPaymentEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoaLoanEligibilityServiceTest {

    @Mock
    private LoaLoanValidationService loaLoanValidationService;

    @Mock
    private LoaLoanEntityService loaLoanEntityService;

    @Mock
    private LoaLoanPaymentEntityService loaLoanPaymentEntityService;

    @InjectMocks
    private LoaLoanService loaLoanService;

    @Test
    void shouldBeEligibleWithFourPercent_WhenCreditScoreAtLeast800() {

        LoaLoanEligibilityRequestDto requestDto = createRequest(1L, "100000", 800, "25000");
        doNothing().when(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);

        LoaLoanEligibilityResponseDto responseDto = loaLoanService.checkEligibility(requestDto);

        assertTrue(responseDto.getEligible());
        assertEquals(0, responseDto.getMaxAmount().compareTo(new BigDecimal("30000.00")));
        assertEquals(0, responseDto.getInterestRate().compareTo(new BigDecimal("4.00")));
        assertEquals("Eligible for requested loan amount.", responseDto.getReason());
        verify(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);
    }

    @Test
    void shouldBeEligibleWithSixPercent_WhenCreditScoreBetween750And799() {

        LoaLoanEligibilityRequestDto requestDto = createRequest(1L, "100000", 760, "25000");
        doNothing().when(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);

        LoaLoanEligibilityResponseDto responseDto = loaLoanService.checkEligibility(requestDto);

        assertTrue(responseDto.getEligible());
        assertEquals(0, responseDto.getInterestRate().compareTo(new BigDecimal("6.00")));
        assertEquals("Eligible for requested loan amount.", responseDto.getReason());
    }

    @Test
    void shouldBeEligibleWithEightPercent_WhenCreditScoreBetween700And749() {

        LoaLoanEligibilityRequestDto requestDto = createRequest(1L, "100000", 700, "25000");
        doNothing().when(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);

        LoaLoanEligibilityResponseDto responseDto = loaLoanService.checkEligibility(requestDto);

        assertTrue(responseDto.getEligible());
        assertEquals(0, responseDto.getInterestRate().compareTo(new BigDecimal("8.00")));
        assertEquals("Eligible for requested loan amount.", responseDto.getReason());
    }

    @Test
    void shouldNotBeEligible_WhenCreditScoreIsLow() {

        LoaLoanEligibilityRequestDto requestDto = createRequest(1L, "100000", 650, "25000");
        doNothing().when(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);

        LoaLoanEligibilityResponseDto responseDto = loaLoanService.checkEligibility(requestDto);

        assertFalse(responseDto.getEligible());
        assertEquals(0, responseDto.getInterestRate().compareTo(new BigDecimal("0.00")));
        assertEquals("Credit score is below minimum requirement.", responseDto.getReason());
    }

    @Test
    void shouldNotBeEligible_WhenRequestedAmountExceedsMaxAmount() {

        LoaLoanEligibilityRequestDto requestDto = createRequest(1L, "100000", 730, "40000");
        doNothing().when(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);

        LoaLoanEligibilityResponseDto responseDto = loaLoanService.checkEligibility(requestDto);

        assertFalse(responseDto.getEligible());
        assertEquals(0, responseDto.getInterestRate().compareTo(new BigDecimal("8.00")));
        assertEquals("Requested amount exceeds maximum eligible amount.", responseDto.getReason());
    }

    @Test
    void shouldNotBeEligible_WhenCreditScoreIsLowAndRequestedAmountExceedsMaxAmount() {

        LoaLoanEligibilityRequestDto requestDto = createRequest(1L, "100000", 650, "40000");
        doNothing().when(loaLoanValidationService).controlIsEligibilityRequestValid(requestDto);

        LoaLoanEligibilityResponseDto responseDto = loaLoanService.checkEligibility(requestDto);

        assertFalse(responseDto.getEligible());
        assertEquals(0, responseDto.getInterestRate().compareTo(new BigDecimal("0.00")));
        assertEquals(
                "Credit score is below minimum requirement and requested amount exceeds maximum eligible amount.",
                responseDto.getReason()
        );
    }

    private LoaLoanEligibilityRequestDto createRequest(
            Long customerId,
            String annualIncome,
            Integer creditScore,
            String requestedAmount) {

        LoaLoanEligibilityRequestDto requestDto = new LoaLoanEligibilityRequestDto();
        requestDto.setCustomerId(customerId);
        requestDto.setAnnualIncome(new BigDecimal(annualIncome));
        requestDto.setCreditScore(creditScore);
        requestDto.setRequestedAmount(new BigDecimal(requestedAmount));
        return requestDto;
    }
}
