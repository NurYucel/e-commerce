package com.nur.business.rules;

import com.nur.common.constants.Messages;
import com.nur.core.exceptions.BusinessException;
import com.nur.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    public void checkIdBalanceIsEnough(Payment payment){
        if (payment.getBalance()<payment.getOrder().getOrderAmount()){
            throw new BusinessException(Messages.Payment.NotEnough);
        }
    }
}
