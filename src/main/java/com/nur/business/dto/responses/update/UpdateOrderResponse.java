package com.nur.business.dto.responses.update;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderResponse {
    private Long id;
    private Long customerId;
    @ElementCollection
    private List<Long> orderItemsIds;
    private double orderAmount;
    private Long paymentId;
}
