package com.company.h2jpa;

import com.company.h2jpa.model.Customer;
import com.company.h2jpa.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TestDb {

    @Autowired
    CustomerRepository repository;

    @Test
    public void test() {
        List<Customer> list = repository.findAll();
        assertThat(list).hasSize(20);
    }
}
