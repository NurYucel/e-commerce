package com.nur.business.dto.responses.create;

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
public class CreateOrderResponse {
    private Long id;
    private Long customerId;
    @ElementCollection
    private List<Long> orderItemsIds;
    private double orderAmount;
    private Long paymentId;

}
