package com.sprint.food_delivery.CustomersModule.Customers;


import java.util.List;

public interface ICustomerService {
    Customers save(CustomerDTO customerDTO);
    List<Customers> getAll();
    Customers findById(Integer id);
    Customers update(Integer id, CustomerDTO customerDTO);
    void delete(Integer id);
}
