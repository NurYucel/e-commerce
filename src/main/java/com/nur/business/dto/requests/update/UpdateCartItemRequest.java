package com.nur.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCartItemRequest {
    private Long id;
    private Long productId;
    private Long cartId;
    private double price;
    private double totalPrice;
}
