package com.rutarj.onlinebankingrestapi.app.loa.dao;

import com.rutarj.onlinebankingrestapi.app.loa.entity.LoaLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaLoanDao extends JpaRepository<LoaLoan,Long> {
}
