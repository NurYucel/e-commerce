package com.nur.business.abstracts;

import com.nur.business.dto.requests.create.CreateCustomerRequest;
import com.nur.business.dto.responses.create.CreateCustomerResponse;
import com.nur.business.dto.responses.get.GetAllCustomersResponse;
import com.nur.business.dto.responses.get.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreateCustomerResponse addCustomer(CreateCustomerRequest request);
    List<GetAllCustomersResponse> getAllCustomer();
    GetCustomerResponse getCustomer(Long id);
    void deleteCustomer(Long id);
}
