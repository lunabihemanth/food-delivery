package com.sprint.food_delivery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRequestDTO;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerResponseDTO;
import com.sprint.food_delivery.CustomersModule.Customers.ICustomerService;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddress;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressDTO;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.IDeliveryAddressService;

@SpringBootTest
public class DeliveryAddressTest {

    @Autowired
    private IDeliveryAddressService addressService;

    @Autowired
    private ICustomerService customerService;

    @Test
    void testCreateAddress() {

        // Step 1: Create Customer
        CustomerRequestDTO customerDTO = new CustomerRequestDTO();
        customerDTO.setCustomerName("Test");
        customerDTO.setCustomerEmail("test@test.com");
        customerDTO.setCustomerPhone("1234567890");

        CustomerResponseDTO customer = customerService.save(customerDTO);

        // Step 2: Create Address
        DeliveryAddressDTO addressDTO = new DeliveryAddressDTO();
        addressDTO.setAddressLine1("Main Street");
        addressDTO.setCity("Chennai");
        addressDTO.setState("TN");
        addressDTO.setPostalCode("600001");
        addressDTO.setCustomerId(customer.getCustomerId());

        DeliveryAddress saved = addressService.save(addressDTO);

        // Step 3: Assert
        assertNotNull(saved.getAddressId());
        assertEquals("Chennai", saved.getCity());
    }
}