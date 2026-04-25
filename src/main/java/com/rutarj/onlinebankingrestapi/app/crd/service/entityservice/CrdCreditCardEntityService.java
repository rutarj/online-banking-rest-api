package com.rutarj.onlinebankingrestapi.app.crd.service.entityservice;

import com.rutarj.onlinebankingrestapi.app.crd.dao.CrdCreditCardDao;
import com.rutarj.onlinebankingrestapi.app.crd.dto.CrdCreditCardDetailsDto;
import com.rutarj.onlinebankingrestapi.app.crd.entity.CrdCreditCard;
import com.rutarj.onlinebankingrestapi.app.gen.enums.GenStatusType;
import com.rutarj.onlinebankingrestapi.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CrdCreditCardEntityService extends BaseEntityService<CrdCreditCard, CrdCreditCardDao> {

    public CrdCreditCardEntityService(CrdCreditCardDao dao) {
        super(dao);
    }

    public List<CrdCreditCard> findAllByStatusType(GenStatusType statusType){
        return getDao().findAllByStatusType(statusType);
    }

    public List<CrdCreditCard> findAllActiveCreditCardList() {
        return getDao().findAllByStatusType(GenStatusType.ACTIVE);
    }

    public CrdCreditCard findByCardNoAndCvvNoAndExpireDate(Long cardNo, Long cvvNo, LocalDate expireDate){
        return getDao().findByCardNoAndCvvNoAndExpireDateAndStatusType(cardNo, cvvNo, expireDate, GenStatusType.ACTIVE);
    }

    public CrdCreditCardDetailsDto getCreditCardDetails(Long creditCardId) {
        return getDao().getCreditCardDetails(creditCardId);
    }
}
