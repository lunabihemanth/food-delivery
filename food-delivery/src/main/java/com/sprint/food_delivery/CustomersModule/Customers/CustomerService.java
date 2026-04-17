package com.sprint.food_delivery.CustomersModule.Customers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

=======

    // CREATE
>>>>>>> e4228a23835a3c366cd2e66f0cc8798175c4b71d
    @Override
    public CustomerResponseDTO save(CustomerRequestDTO dto) {
        Customers customer = new Customers();

        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhone(dto.getCustomerPhone());

        Customers saved = customerRepository.save(customer);

        return new CustomerResponseDTO(
                saved.getCustomerId(),
                saved.getCustomerName(),
                saved.getCustomerEmail(),
                saved.getCustomerPhone()
        );
    }

    // GET ALL
    @Override
    public List<CustomerResponseDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(c -> new CustomerResponseDTO(
                        c.getCustomerId(),
                        c.getCustomerName(),
                        c.getCustomerEmail(),
                        c.getCustomerPhone()))
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public CustomerResponseDTO findById(Integer id) {
        Customers c = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return new CustomerResponseDTO(
                c.getCustomerId(),
                c.getCustomerName(),
                c.getCustomerEmail(),
                c.getCustomerPhone()
        );
    }

    // UPDATE
    @Override
    public CustomerResponseDTO update(Integer id, CustomerRequestDTO dto) {
        Customers existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existing.setCustomerName(dto.getCustomerName());
        existing.setCustomerEmail(dto.getCustomerEmail());
        existing.setCustomerPhone(dto.getCustomerPhone());

        Customers updated = customerRepository.save(existing);

        return new CustomerResponseDTO(
                updated.getCustomerId(),
                updated.getCustomerName(),
                updated.getCustomerEmail(),
                updated.getCustomerPhone()
        );
    }

    // DELETE
    @Override
    public void delete(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }

    
}