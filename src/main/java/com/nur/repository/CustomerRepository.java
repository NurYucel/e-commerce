package com.nur.repository;

import com.nur.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByEmail(String email);
    boolean existsById(Long id);
}
