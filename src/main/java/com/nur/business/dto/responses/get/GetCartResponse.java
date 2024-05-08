package com.nur.business.dto.responses.get;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCartResponse {
    private Long id;
    private Long customerId;
    @ElementCollection
    Set<Long> cartItemIds;

}
