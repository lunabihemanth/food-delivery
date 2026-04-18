/*  package com.sprint.food_delivery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRequestDTO;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerResponseDTO;
import com.sprint.food_delivery.CustomersModule.Customers.ICustomerService;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private ICustomerService customerService;

    @Test
    void testCreateCustomer() {
        CustomerRequestDTO dto = new CustomerRequestDTO();
        dto.setCustomerName("Luna");
        dto.setCustomerEmail("luna@test.com");
        dto.setCustomerPhone("9876543210");

        CustomerResponseDTO save = customerService.save(dto);

        assertNotNull(save.getCustomerId());
        assertEquals("Luna", save.getCustomerName());
    }
}

 */