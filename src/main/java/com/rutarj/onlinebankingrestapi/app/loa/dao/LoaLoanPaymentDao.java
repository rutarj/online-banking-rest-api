package com.rutarj.onlinebankingrestapi.app.loa.dao;

import com.rutarj.onlinebankingrestapi.app.loa.entity.LoaLoanPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaLoanPaymentDao extends JpaRepository<LoaLoanPayment,Long> {
}
