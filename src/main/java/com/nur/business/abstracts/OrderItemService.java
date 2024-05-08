package com.nur.business.abstracts;

import com.nur.business.dto.responses.get.GetAllOrdersResponse;
import com.nur.entities.OrderItem;

import java.util.List;

public interface OrderItemService {
    void addProductToOrder(Long orderID, Long productId, int quantity);
    void removeProductFromOrder(Long orderId, Long productId);
    List<GetAllOrdersResponse> getAll();
    OrderItem getById(Long id);
}
