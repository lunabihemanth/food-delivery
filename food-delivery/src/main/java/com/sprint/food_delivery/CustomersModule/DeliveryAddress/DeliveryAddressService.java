package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;
import com.sprint.food_delivery.Exception.CustomerNotFoundException;
import com.sprint.food_delivery.Exception.DeliveryAddressNotFoundException;

@Service
public class DeliveryAddressService implements IDeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    @Override
    public DeliveryAddressResponseDTO save(DeliveryAddressRequestDTO dto) {

        Customers customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(dto.getCustomerId()));

        DeliveryAddress address = new DeliveryAddress();
        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());
        address.setCustomer(customer);

        DeliveryAddress saved = deliveryAddressRepository.save(address);

        return mapToResponseDTO(saved);
    }

    // GET ALL
    @Override
    public List<DeliveryAddressResponseDTO> getAll() {
        return deliveryAddressRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public DeliveryAddressResponseDTO findById(Integer id) {
        DeliveryAddress address = deliveryAddressRepository.findById(id)
                .orElseThrow(() -> new DeliveryAddressNotFoundException(id));

        return mapToResponseDTO(address);
    }

    // Get by Customer Id
    @Override
    public List<DeliveryAddressResponseDTO> getByCustomerId(Integer customerId) {

        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }

        return deliveryAddressRepository.findByCustomer_CustomerId(customerId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // Update
    @Override
    public DeliveryAddressResponseDTO update(Integer id, DeliveryAddressRequestDTO dto) {

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

        DeliveryAddress updated = deliveryAddressRepository.save(existing);

        return mapToResponseDTO(updated);
    }

    // Delete
    @Override
    public String delete(Integer id) {
        if (!deliveryAddressRepository.existsById(id)) {
            throw new DeliveryAddressNotFoundException(id);
        }
        deliveryAddressRepository.deleteById(id);
        
        return "Deleted this id";
    }

    //Mapper Method
    private DeliveryAddressResponseDTO mapToResponseDTO(DeliveryAddress address) {
        return new DeliveryAddressResponseDTO(
                address.getAddressId(),
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getCity(),
                address.getState(),
                address.getPostalCode(),
                address.getCustomer().getCustomerId()
        );
    }
}