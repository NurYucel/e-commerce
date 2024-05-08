package com.nur.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCartItemsResponse {
    private Long id;
    private Long productId;
    private Long cartId;
    private double price;
    private double totalPrice;

}
