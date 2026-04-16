package com.sprint.food_delivery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerDTO;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerNotFoundException;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;
import com.sprint.food_delivery.CustomersModule.Customers.ICustomerService;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressRepository;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository; // inject child repo

    @BeforeEach
    void cleanUp() {
        deliveryAddressRepository.deleteAll(); // delete children FIRST
        customerRepository.deleteAll();        // then delete parents
    }

    private CustomerDTO buildDTO(String name, String email, String phone) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerName(name);
        dto.setCustomerEmail(email);
        dto.setCustomerPhone(phone);
        return dto;
    }

    @Test
    void testCreateCustomer() {
        CustomerDTO dto = buildDTO("Lunabi", "lunabi@test.com", "1234567890");
        Customers saved = customerService.save(dto);
        assertNotNull(saved.getCustomerId());
        assertEquals("Lunabi", saved.getCustomerName());
        assertEquals("lunabi@test.com", saved.getCustomerEmail());
    }

    @Test
    void testFindCustomerById() {
        Customers saved = customerService.save(buildDTO("Test User", "testuser@test.com", "9999999999"));
        Customers found = customerService.findById(saved.getCustomerId());
        assertEquals(saved.getCustomerId(), found.getCustomerId());
    }

    @Test
    void testUpdateCustomer() {
        Customers saved = customerService.save(buildDTO("Old Name", "old@test.com", "1111111111"));
        CustomerDTO updateDTO = buildDTO("New Name", "old@test.com", "2222222222");
        Customers updated = customerService.update(saved.getCustomerId(), updateDTO);
        assertEquals("New Name", updated.getCustomerName());
        assertEquals("2222222222", updated.getCustomerPhone());
    }

    @Test
    void testDeleteCustomer() {
        Customers saved = customerService.save(buildDTO("Delete Me", "deleteme@test.com", "8888888888"));
        customerService.delete(saved.getCustomerId());
        assertThrows(CustomerNotFoundException.class, () -> customerService.findById(saved.getCustomerId()));
    }

    @Test
    void testCustomerNotFound() {
        assertThrows(CustomerNotFoundException.class, () -> customerService.findById(99999));
    }
}