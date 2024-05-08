package com.nur.business.abstracts;

import com.nur.business.dto.requests.create.CreatePaymentRequest;
import com.nur.business.dto.requests.update.UpdatePaymentRequest;
import com.nur.business.dto.responses.create.CreatePaymentResponse;
import com.nur.business.dto.responses.get.GetAllPaymentsResponse;
import com.nur.business.dto.responses.get.GetPaymentResponse;
import com.nur.business.dto.responses.update.UpdatePaymentResponse;
import com.nur.entities.Payment;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();
    GetPaymentResponse getById(Long id);

    Payment createPayment(CreatePaymentRequest request);
     void delete(Long id);
    void processPayment(Payment payment);
}
