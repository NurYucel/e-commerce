package com.nur.api;

import com.nur.business.abstracts.CustomerService;
import com.nur.business.dto.requests.create.CreateCustomerRequest;
import com.nur.business.dto.requests.update.UpdateCustomerRequest;
import com.nur.business.dto.responses.create.CreateCustomerResponse;
import com.nur.business.dto.responses.get.GetAllCustomersResponse;
import com.nur.business.dto.responses.get.GetCustomerResponse;
import com.nur.business.dto.responses.update.UpdateCustomerResponse;
import com.nur.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAllCustomer(){
        return service.getAllCustomer();
    }

    @PutMapping("/add-customer")
    public CreateCustomerResponse addCustomer(CreateCustomerRequest request){
        return service.addCustomer(request);
    }

    @GetMapping("/{id")
    public GetCustomerResponse getCustomer(Long id){
        return service.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteCustomer(id);
    }
}
