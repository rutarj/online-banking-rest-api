package com.rutarj.onlinebankingrestapi.app.log.dao;

import com.rutarj.onlinebankingrestapi.app.log.entity.LogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDetailsDao extends JpaRepository<LogDetail, Long> {
}
