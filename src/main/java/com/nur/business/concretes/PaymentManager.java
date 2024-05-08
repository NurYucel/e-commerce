package com.nur.business.concretes;

import com.nur.business.abstracts.PaymentService;
import com.nur.business.dto.requests.create.CreatePaymentRequest;
import com.nur.business.dto.responses.get.GetAllPaymentsResponse;
import com.nur.business.dto.responses.get.GetPaymentResponse;
import com.nur.business.rules.PaymentBusinessRules;
import com.nur.entities.Payment;
import com.nur.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final ModelMapper mapper;
    private final PaymentRepository repository;
    private final PaymentBusinessRules rules;
    @Override
    public List<GetAllPaymentsResponse> getAll() {
        return repository.findAll().stream()
                .map(payment -> mapper.map(payment, GetAllPaymentsResponse.class))
                .toList();
    }

    @Override
    public GetPaymentResponse getById(Long id) {
        Payment payment = repository.findById(id).orElseThrow();
        return mapper.map(payment,GetPaymentResponse.class);
    }

    @Override
    public Payment createPayment(CreatePaymentRequest request) {
        Payment payment = mapper.map(request,Payment.class);
        return repository.save(payment);
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void processPayment(Payment payment) {
        rules.checkIdBalanceIsEnough(payment);
        double newBalance = payment.getBalance()-payment.getOrder().getOrderAmount();
        payment.setBalance(newBalance);
        repository.save(payment);
    }
}
