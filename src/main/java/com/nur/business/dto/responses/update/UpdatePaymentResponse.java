package com.nur.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentResponse {
    private Long id;
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int carExpirationMonth;
    private String carCvv;
    private double balance;
    private Long orderId;
}
