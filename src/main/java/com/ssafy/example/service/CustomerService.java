package com.ssafy.example.service;

import com.ssafy.example.entity.Customer;
import com.ssafy.example.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public String regist(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(String id) {
        return customerRepository.findById(id);
    }

    public Customer search(String id) {
        return customerRepository.findById(id);
    }
}
