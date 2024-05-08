package com.nur.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartItemResponse {
    private Long id;
    private Long productId;
    private Long cartId;
    private double price;
    private double totalPrice;
}
