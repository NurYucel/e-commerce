package com.nur.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartItemResponse {
    private Long id;
    private Long cartId;
    private Long productId;
    private double productPrice;

}
