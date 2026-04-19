package com.sprint.food_delivery.customersmodule.customers;


import java.util.List;

public interface ICustomerService {
    CustomerResponseDTO save(CustomerRequestDTO dto);
    List<CustomerResponseDTO> getAll();
    CustomerResponseDTO findById(Integer id);
    CustomerResponseDTO update(Integer id, CustomerRequestDTO dto);
    String delete(Integer id);
}