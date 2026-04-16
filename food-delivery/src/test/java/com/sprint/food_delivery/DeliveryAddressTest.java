package com.sprint.food_delivery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerDTO;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;
import com.sprint.food_delivery.CustomersModule.Customers.ICustomerService;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddress;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressDTO;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressNotFoundException;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.DeliveryAddressRepository;
import com.sprint.food_delivery.CustomersModule.DeliveryAddress.IDeliveryAddressService;

@SpringBootTest
public class DeliveryAddressTest {

    @Autowired
    private IDeliveryAddressService deliveryAddressService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private Integer testCustomerId;

    @BeforeEach
    void setUp() {
        deliveryAddressRepository.deleteAll(); // children first
        customerRepository.deleteAll();

        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerName("Test Customer");
        dto.setCustomerEmail("addr_test@test.com");
        dto.setCustomerPhone("1234567890");
        Customers saved = customerService.save(dto);
        testCustomerId = saved.getCustomerId();
    }

    private DeliveryAddressDTO buildDTO(String line1, String city) {
        DeliveryAddressDTO dto = new DeliveryAddressDTO();
        dto.setAddressLine1(line1);
        dto.setAddressLine2("Near Park");
        dto.setCity(city);
        dto.setState("Tamil Nadu");
        dto.setPostalCode("600001");
        dto.setCustomerId(testCustomerId);
        return dto;
    }

    @Test
    void testCreateAddress() {
        DeliveryAddress saved = deliveryAddressService.save(buildDTO("12 Main St", "Chennai"));
        assertNotNull(saved.getAddressId());
        assertEquals("12 Main St", saved.getAddressLine1());
        assertEquals("Chennai", saved.getCity());
    }

    @Test
    void testGetById() {
        DeliveryAddress saved = deliveryAddressService.save(buildDTO("45 Lake View", "Coimbatore"));
        DeliveryAddress found = deliveryAddressService.getById(saved.getAddressId());
        assertEquals(saved.getAddressId(), found.getAddressId());
    }

    @Test
    void testGetByCustomerId() {
        deliveryAddressService.save(buildDTO("Addr 1", "Chennai"));
        deliveryAddressService.save(buildDTO("Addr 2", "Madurai"));
        List<DeliveryAddress> list = deliveryAddressService.getByCustomerId(testCustomerId);
        assertEquals(2, list.size());
    }

    @Test
    void testUpdateAddress() {
        DeliveryAddress saved = deliveryAddressService.save(buildDTO("Old Street", "Chennai"));
        DeliveryAddressDTO updateDTO = buildDTO("New Street", "Trichy");
        DeliveryAddress updated = deliveryAddressService.update(saved.getAddressId(), updateDTO);
        assertEquals("New Street", updated.getAddressLine1());
        assertEquals("Trichy", updated.getCity());
    }

    @Test
    void testDeleteAddress() {
        DeliveryAddress saved = deliveryAddressService.save(buildDTO("Delete St", "Chennai"));
        deliveryAddressService.delete(saved.getAddressId());
        assertThrows(DeliveryAddressNotFoundException.class,
                () -> deliveryAddressService.getById(saved.getAddressId()));
    }

    @Test
    void testAddressNotFound() {
        assertThrows(DeliveryAddressNotFoundException.class,
                () -> deliveryAddressService.getById(99999));
    }
}