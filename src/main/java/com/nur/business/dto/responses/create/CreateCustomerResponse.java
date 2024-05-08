package com.nur.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerResponse {
    private Long id;
    private String name;
    private String email;
    private Long cartId;
}
