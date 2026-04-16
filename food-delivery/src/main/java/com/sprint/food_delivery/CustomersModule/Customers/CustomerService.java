package com.sprint.food_delivery.CustomersModule.Customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customers save(CustomerDTO dto) {
        if (customerRepository.existsByCustomerEmail(dto.getCustomerEmail())) {
            throw new CustomerAlreadyExistsException(dto.getCustomerEmail());
        }
        Customers customer = new Customers();
        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhone(dto.getCustomerPhone());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customers> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customers findById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customers update(Integer id, CustomerDTO dto) {
        Customers existing = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        existing.setCustomerName(dto.getCustomerName());
        existing.setCustomerEmail(dto.getCustomerEmail());
        existing.setCustomerPhone(dto.getCustomerPhone());
        return customerRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
    }
}
