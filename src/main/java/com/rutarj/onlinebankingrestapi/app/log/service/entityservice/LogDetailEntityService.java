package com.rutarj.onlinebankingrestapi.app.log.service.entityservice;

import com.rutarj.onlinebankingrestapi.app.gen.service.BaseEntityService;
import com.rutarj.onlinebankingrestapi.app.log.dao.LogDetailsDao;
import com.rutarj.onlinebankingrestapi.app.log.entity.LogDetail;
import org.springframework.stereotype.Service;

@Service
public class LogDetailEntityService extends BaseEntityService<LogDetail, LogDetailsDao> {

    public LogDetailEntityService(LogDetailsDao dao) {
        super(dao);
    }
}
