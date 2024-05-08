package com.nur.business.concretes;

import com.nur.business.abstracts.CartService;
import com.nur.business.abstracts.OrderService;
import com.nur.business.abstracts.PaymentService;
import com.nur.business.abstracts.ProductService;
import com.nur.business.dto.requests.create.CreateOrderRequest;
import com.nur.business.dto.responses.create.CreateOrderResponse;
import com.nur.business.dto.responses.get.GetAllOrdersResponse;
import com.nur.business.dto.responses.get.GetOrderResponse;
import com.nur.entities.*;
import com.nur.repository.OrderItemRepository;
import com.nur.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository repository;
    private final ModelMapper mapper;

    private final CartService cartService;
    private final PaymentService paymentService;
    private final ProductService productService;

    private final OrderItemRepository orderItemRepository;

    @Override
    public Order placeOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order getOrderForCode(String orderCode) {
        return repository.findByOrderCode(orderCode);
    }

    @Override
    public List<Order> getAllOrderForCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = repository.findAll();
        return orders
                .stream()
                .map(order -> mapper.map(order,GetAllOrdersResponse.class))
                .toList();
    }

    @Override
    public GetOrderResponse getById(Long id) {
        Order order = repository.findById(id).orElseThrow();
        GetOrderResponse response = mapper.map(order,GetOrderResponse.class);
        response.setOrderItemsIds(getOrderItemIdsAsList(order));
        return response;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        Cart cart = cartService.getCart(request.getCartId());
        Order order = new Order();
        order.setOrderedAt(LocalDateTime.now());
        order.setCustomer(cart.getCustomer());
        List<OrderItem> orderItems = mapCartItemsOrderItems(cart);
        order.setOrderItems(orderItems);
        order.setOrderAmount(cart.getTotalPrice());

        Payment payment = paymentService.createPayment(request.getPaymentRequest());
        if(payment == null){
            throw new RuntimeException("Payment could not be created");
        }

        order.setPayment(payment);

        Order createdOrder = repository.save(order);

        payment.setOrder(createdOrder);
        paymentService.processPayment(payment);

        cartService.emptyCart(request.getCartId());
        repository.save(createdOrder);
        setOrderForOrderItems(orderItems,createdOrder);

        CreateOrderResponse response = mapper.map(createdOrder,CreateOrderResponse.class);
        response.setOrderItemsIds(getOrderItemIdsAsList(createdOrder));

        return response;
    }

    @Override
    public void delete(Long id) {
        Order order = repository.findById(id).orElseThrow();
        orderItemRepository.deleteAll(order.getOrderItems());
        repository.deleteById(id);
    }

    public List<Long> getOrderItemIdsAsList(Order order){
        List<Long> orderItemIds = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()){
            orderItemIds.add(orderItem.getId());
        }
        return orderItemIds;
    }
    public List<OrderItem> mapCartItemsOrderItems(Cart cart){
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()){
            OrderItem orderItem = mapper.map(cartItem,OrderItem.class);
            orderItems.add(orderItem);
        }
        cartService.emptyCart(cart.getId());
        return orderItems;
    }
    public void setOrderForOrderItems(List<OrderItem> orderItems,Order createdOrder){
        for (OrderItem orderItem : orderItems){
            orderItem.setOrder(createdOrder);
            orderItemRepository.save(orderItem);
        }
    }
}
