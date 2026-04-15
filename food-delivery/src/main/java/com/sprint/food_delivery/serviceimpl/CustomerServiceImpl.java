package com.sprint.food_delivery.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.Customers;
import com.sprint.food_delivery.repository.CustomerRepository;
import com.sprint.food_delivery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customers addCustomer(Customers customer) {
        return repository.save(customer);
    }

}