package com.sprint.food_delivery.servicetest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRequestDTO;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerResponseDTO;
import com.sprint.food_delivery.CustomersModule.Customers.ICustomerService;

@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired
    private ICustomerService customerService;

    // ✅ POSITIVE TEST (Valid Customer Save)
    @Test
    void testSaveCustomerSuccess() {
        CustomerRequestDTO dto = new CustomerRequestDTO();
        dto.setCustomerName("John Doe");
        dto.setCustomerEmail("john" + System.currentTimeMillis() + "@mail.com"); // unique email
        dto.setCustomerPhone("9999999999");

        CustomerResponseDTO response = customerService.save(dto);

        assertNotNull(response);
        assertEquals(dto.getCustomerName(), response.getCustomerName());
    }

    // ❌ NEGATIVE TEST (Duplicate Email)
    @Test
    void testSaveCustomerDuplicateEmail() {
        String email = "test" + System.currentTimeMillis() + "@mail.com";

        CustomerRequestDTO dto1 = new CustomerRequestDTO();
        dto1.setCustomerName("User One");
        dto1.setCustomerEmail(email);
        dto1.setCustomerPhone("1111111111");

        customerService.save(dto1); // first insert

        CustomerRequestDTO dto2 = new CustomerRequestDTO();
        dto2.setCustomerName("User Two");
        dto2.setCustomerEmail(email); // same email
        dto2.setCustomerPhone("2222222222");

        assertThrows(Exception.class, () -> {
            customerService.save(dto2);
        });
    }

    
}