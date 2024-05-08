package com.nur.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderItemResponse {
    private Long id;
    private double price;
    private Long productId;
    private Long orderId;
    private int quantity;
}
