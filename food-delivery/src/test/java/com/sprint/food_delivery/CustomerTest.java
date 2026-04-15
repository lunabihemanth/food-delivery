package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private CustomerRepository repo;

    @Test
    void testCreateCustomer() {
        Customers c = new Customers();
        c.setCustomerName("Lunabi");
        c.setCustomerEmail("lunabi@test.com");
        c.setCustomerPhone("1234567890");
        Customers saved = repo.save(c);
    }

    @Test
    void testFindCustomer() {
        Customers c = new Customers();
        c.setCustomerName("Test User");
        c.setCustomerEmail("test@test.com");
        c.setCustomerPhone("9999999999");

        Customers saved = repo.save(c);
    }
    
}
