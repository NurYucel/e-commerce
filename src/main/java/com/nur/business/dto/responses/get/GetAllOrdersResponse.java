package com.nur.business.dto.responses.get;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllOrdersResponse {
    private Long id;
    private Long customerId;
    @ElementCollection
    private List<Long> orderItemsIds;
    private double orderAmount;
    private Long paymentId;

}
