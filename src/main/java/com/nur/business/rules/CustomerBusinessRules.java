package com.nur.business.rules;

import com.nur.core.exceptions.BusinessException;
import com.nur.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository repository;
    public void checkIfEmailExists(String email){
        if (repository.existsByEmail(email)){
            throw new BusinessException("EMAIL_ALREADY_EXISTS");
        }
    }
    public void checkIfExistsById(Long id){
        if (!repository.existsById(id)){
            throw new BusinessException("NOT_EXISTS_BY_ID");
        }
    }
}
