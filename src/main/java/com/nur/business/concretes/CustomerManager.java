package com.nur.business.concretes;

import com.nur.business.abstracts.CartService;
import com.nur.business.abstracts.CustomerService;
import com.nur.business.dto.requests.create.CreateCustomerRequest;
import com.nur.business.dto.responses.create.CreateCustomerResponse;
import com.nur.business.dto.responses.get.GetAllCustomersResponse;
import com.nur.business.dto.responses.get.GetCustomerResponse;
import com.nur.business.rules.CustomerBusinessRules;
import com.nur.entities.Cart;
import com.nur.entities.Customer;
import com.nur.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerBusinessRules rules;

    private final CartService cartService;

    @Override
    public CreateCustomerResponse addCustomer(CreateCustomerRequest request) {
        rules.checkIfEmailExists(request.getEmail());

        Customer customer = mapper.map(request, Customer.class);

        Cart cart = cartService.createCart();
        customer.setCart(cart);

        Customer createdCustomer = repository.save(customer);
        cartService.setUserForCart(cart, createdCustomer);

        CreateCustomerResponse response = mapper.map(createdCustomer, CreateCustomerResponse.class);
        response.setCartId(cart.getId());
        return response;
    }

    @Override
    public List<GetAllCustomersResponse> getAllCustomer() {
        List<Customer> customers = repository.findAll();
        return customers
                .stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class))
                .toList();
    }

    @Override
    public GetCustomerResponse getCustomer(Long id) {
        rules.checkIfExistsById(id);
        Customer customer = repository.findById(id).orElseThrow();

        GetCustomerResponse response = mapper.map(customer, GetCustomerResponse.class);
        response.setCartId(customer.getCart().getId());
        return response;
    }

    @Override
    public void deleteCustomer(Long id) {
        rules.checkIfExistsById(id);
        repository.deleteById(id);
    }
}
