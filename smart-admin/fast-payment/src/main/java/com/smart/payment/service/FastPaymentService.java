package com.smart.payment.service;

import com.smart.payment.common.RespEntity;
import com.smart.payment.domain.entity.CreditCard;

public interface FastPaymentService {
    RespEntity<CreditCard> findAll();
    int saveCredCard();
}
