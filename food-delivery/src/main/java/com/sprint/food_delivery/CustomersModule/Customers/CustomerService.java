package com.sprint.food_delivery.CustomersModule.Customers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {


	@Autowired
	private CustomerRepository customerRepository;
	public Customers save(Customers customer) {
        return customerRepository.save(customer);
    }
    public List<Customers> getAll() {
        return customerRepository.findAll();
    }
    public Customers findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
    public Customers update(Integer id, Customers customer) {
        Customers existing = customerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCustomerName(customer.getCustomerName());
            existing.setCustomerEmail(customer.getCustomerEmail());
            existing.setCustomerPhone(customer.getCustomerPhone());
            return customerRepository.save(existing);
        }
        return null;
    }
    public void delete(Integer id) {
        customerRepository.deleteById(id);
        System.out.println("Deleted customer: " + id);
    }

}
	

