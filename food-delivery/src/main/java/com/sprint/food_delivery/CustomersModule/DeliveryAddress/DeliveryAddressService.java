 package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerNotFoundException;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;

@Service
public class DeliveryAddressService implements IDeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    private CustomerRepository customerRepository; // to validate customer exists

    @Override
    public DeliveryAddress save(DeliveryAddressDTO dto) {
        Customers customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(dto.getCustomerId()));

        DeliveryAddress address = new DeliveryAddress();
        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());
        address.setCustomer(customer);

        return deliveryAddressRepository.save(address);
    }

    @Override
    public List<DeliveryAddress> getAll() {
        return deliveryAddressRepository.findAll();
    }

    @Override
    public DeliveryAddress getById(Integer id) {
        return deliveryAddressRepository.findById(id)
                .orElseThrow(() -> new DeliveryAddressNotFoundException(id));
    }

    @Override
    public List<DeliveryAddress> getByCustomerId(Integer customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }
        return deliveryAddressRepository.findByCustomer_CustomerId(customerId);
    }

    @Override
    public DeliveryAddress update(Integer id, DeliveryAddressDTO dto) {
        DeliveryAddress existing = deliveryAddressRepository.findById(id)
                .orElseThrow(() -> new DeliveryAddressNotFoundException(id));

        Customers customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(dto.getCustomerId()));

        existing.setAddressLine1(dto.getAddressLine1());
        existing.setAddressLine2(dto.getAddressLine2());
        existing.setCity(dto.getCity());
        existing.setState(dto.getState());
        existing.setPostalCode(dto.getPostalCode());
        existing.setCustomer(customer);

        return deliveryAddressRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        if (!deliveryAddressRepository.existsById(id)) {
            throw new DeliveryAddressNotFoundException(id);
        }
        deliveryAddressRepository.deleteById(id);
    }
}