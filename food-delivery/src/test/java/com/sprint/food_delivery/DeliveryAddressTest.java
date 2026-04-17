package com.sprint.food_delivery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRequestDTO;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerResponseDTO;
import com.sprint.food_delivery.CustomersModule.Customers.ICustomerService;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressRequestDTO;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressResponseDTO;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.IDeliveryAddressService;

@SpringBootTest
public class DeliveryAddressTest {

    @Autowired
    private IDeliveryAddressService addressService;

    @Autowired
    private ICustomerService customerService;

    @Test
    void testCreateAddress() {

        // 👉 Create Customer
        CustomerRequestDTO customerDTO = new CustomerRequestDTO();
        customerDTO.setCustomerName("Test User");
        customerDTO.setCustomerEmail("test@test.com");
        customerDTO.setCustomerPhone("9876543210");

        CustomerResponseDTO customer = customerService.save(customerDTO);

        // 👉 Create Address
        DeliveryAddressRequestDTO addressDTO = new DeliveryAddressRequestDTO();
        addressDTO.setAddressLine1("Main Street");
        addressDTO.setCity("Chennai");
        addressDTO.setState("TN");
        addressDTO.setPostalCode("600001");
        addressDTO.setCustomerId(customer.getCustomerId());

        DeliveryAddressResponseDTO saved = addressService.save(addressDTO);

        // 👉 Assertions
        assertNotNull(saved.getAddressId());
        assertEquals("Chennai", saved.getCity());
        assertEquals("TN", saved.getState());
    }
}