package com.company.h2jpa.repository;

import com.company.h2jpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllById(int id);
}
