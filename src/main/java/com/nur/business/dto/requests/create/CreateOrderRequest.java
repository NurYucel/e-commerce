package com.nur.business.dto.requests.create;

import com.nur.entities.Payment;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrderRequest {
    private Long customerId;
    @ElementCollection
    private List<Long> orderItemsIds;
    private double orderAmount;
    private Long paymentId;
    private Long cartId;
    CreatePaymentRequest paymentRequest;
}
