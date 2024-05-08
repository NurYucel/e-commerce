package com.nur.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentRequest {
    private Long id;
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int carExpirationMonth;
    private String carCvv;
    private double balance;
    private Long orderId;
}
