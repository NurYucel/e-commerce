package com.nur.api;

import com.nur.business.abstracts.PaymentService;
import com.nur.business.dto.requests.create.CreatePaymentRequest;
import com.nur.business.dto.responses.create.CreatePaymentResponse;
import com.nur.business.dto.responses.get.GetAllPaymentsResponse;
import com.nur.business.dto.responses.get.GetPaymentResponse;
import com.nur.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;

    @GetMapping
    public List<GetAllPaymentsResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment add(@RequestBody CreatePaymentRequest request){
        return service.createPayment(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){
        service.delete(id);
    }


}
