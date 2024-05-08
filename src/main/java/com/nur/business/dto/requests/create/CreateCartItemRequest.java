package com.nur.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCartItemRequest {
    private Long id;
    private Long productId;
    private Long cartId;
    private double price;
    private double totalPrice;
}
