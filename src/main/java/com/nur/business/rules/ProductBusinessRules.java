package com.nur.business.rules;

import com.nur.common.constants.Messages;
import com.nur.core.exceptions.BusinessException;
import com.nur.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;
    public void checkIfProductExistsById(Long id){
        if (!repository.existsById(id)){
            throw new BusinessException(Messages.Product.NotExists);
        }
    }
}
