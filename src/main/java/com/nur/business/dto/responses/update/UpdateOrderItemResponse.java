package com.nur.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderItemResponse {
    private Long id;
    private double price;
    private Long productId;
    private Long orderId;
    private int quantity;
}
