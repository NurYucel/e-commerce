package com.nur.business.concretes;

import com.nur.business.abstracts.OrderItemService;
import com.nur.business.dto.responses.get.GetAllOrdersResponse;
import com.nur.entities.OrderItem;
import com.nur.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemManager implements OrderItemService {
    private final OrderItemRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addProductToOrder(Long orderID, Long productId, int quantity) {

    }

    @Override
    public void removeProductFromOrder(Long orderId, Long productId) {

    }

    @Override
    public List<GetAllOrdersResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(orderItem -> mapper.map(orderItem,GetAllOrdersResponse.class))
                .toList();
    }

    @Override
    public OrderItem getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
