package com.nur.business.dto.responses.get;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetOrderResponse {
    private Long id;
    private Long customerId;
    @ElementCollection
    private List<Long> orderItemsIds = new ArrayList<>();
    private double orderAmount;
    private Long paymentId;
}
