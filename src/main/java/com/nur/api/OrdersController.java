package com.nur.api;

import com.nur.business.abstracts.OrderItemService;
import com.nur.business.abstracts.OrderService;
import com.nur.business.dto.requests.create.CreateOrderRequest;
import com.nur.business.dto.responses.create.CreateOrderResponse;
import com.nur.business.dto.responses.get.GetAllOrdersResponse;
import com.nur.business.dto.responses.get.GetOrderResponse;
import com.nur.entities.Order;
import com.nur.entities.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderService service;
    private final OrderItemService orderItemService;

    @PutMapping("/place-order")
    public Order placeOrder(@RequestBody Order order){
        return service.placeOrder(order);
    }

    @GetMapping
    public Order getOrderForCode(@PathVariable String orderCode){
        return service.getOrderForCode(orderCode);
    }

    @GetMapping
    public List<Order> getAllOrderForCustomer(@PathVariable Long customerId){
        return service.getAllOrderForCustomer(customerId);
    }

    @PutMapping("/create-order")
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request){
        return  service.createOrder(request);
    }

    @GetMapping
    public List<GetAllOrdersResponse>  getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetOrderResponse getOrderById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/add-product-to-order")
    public void addProductToOrder(@PathVariable Long orderId,@PathVariable Long productId,@PathVariable int quantity){
        orderItemService.addProductToOrder(orderId, productId, quantity);
    }

    @DeleteMapping("/remove-product-from-order")
    public void  removeProductFromOrder(@PathVariable Long orderId,@PathVariable Long productId){
        orderItemService.removeProductFromOrder(orderId, productId);
    }

    @GetMapping
    public OrderItem getById(@PathVariable Long id){
        return orderItemService.getById(id);
    }


}
