package com.rutarj.onlinebankingrestapi.app.acc.service.entityservice;

import com.rutarj.onlinebankingrestapi.app.acc.dao.AccMoneyTransferDao;
import com.rutarj.onlinebankingrestapi.app.acc.entity.AccMoneyTransfer;
import com.rutarj.onlinebankingrestapi.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccMoneyTransferEntityService extends BaseEntityService<AccMoneyTransfer, AccMoneyTransferDao> {
    public AccMoneyTransferEntityService(AccMoneyTransferDao accMoneyTransferDao){
        super(accMoneyTransferDao);
    }
}
