package com.nur.business.abstracts;

import com.nur.business.dto.requests.create.CreateOrderRequest;
import com.nur.business.dto.responses.create.CreateOrderResponse;
import com.nur.business.dto.responses.get.GetAllOrdersResponse;
import com.nur.business.dto.responses.get.GetOrderResponse;
import com.nur.entities.Order;


import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);
    Order getOrderForCode(String orderCode);
    List<Order> getAllOrderForCustomer(Long customerId);
    List<GetAllOrdersResponse> getAll();
    GetOrderResponse getById(Long id);

    CreateOrderResponse createOrder(CreateOrderRequest request);
    void delete(Long id);

}
