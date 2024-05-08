package com.nur.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrderItemRequest {
    private Long id;
    private double price;
    private Long productId;
    private Long orderId;
    private int quantity;
}
