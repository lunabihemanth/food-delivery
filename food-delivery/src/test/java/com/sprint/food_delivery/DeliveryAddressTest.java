package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddress;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressRepository;

@SpringBootTest
public class DeliveryAddressTest {

    @Autowired
    private DeliveryAddressRepository addrepo;
    
    @Autowired
    private CustomerRepository customerRepo;

     @Test
    void testCreateAddress() {

        Customers c = new Customers();
        c.setCustomerName("John");
        c.setCustomerEmail("john@gmail.com");
        c.setCustomerPhone("9876543210");

        Customers savedCustomer = customerRepo.save(c);

        
        DeliveryAddress addr = new DeliveryAddress();
        addr.setAddressLine1("123 Main Street");
        addr.setCity("Mumbai");
        addr.setState("MH");
        addr.setPostalCode("400001");
        addr.setCustomer(savedCustomer);
        DeliveryAddress saved = addrepo.save(addr);
    }

    
}
