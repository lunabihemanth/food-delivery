package com.sprint.food_delivery;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.sprint.food_delivery.CustomersModule.Customers.CustomerRepository;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testSaveAndFindByEmail() {

        Customers c = new Customers();
        c.setCustomerName("John");
        c.setCustomerEmail("john@test.com");
        c.setCustomerPhone("1234567890");

        repository.save(c);

        Optional<Customers> found = repository.findByCustomerEmail("john@test.com");

        assertThat(found).isPresent();
        assertThat(found.get().getCustomerName()).isEqualTo("John");
    }

    @Test
    void testExistsByEmail() {

        Customers c = new Customers();
        c.setCustomerName("Jane");
        c.setCustomerEmail("jane@test.com");
        c.setCustomerPhone("9876543210");

        repository.save(c);

        boolean exists = repository.existsByCustomerEmail("jane@test.com");

        assertThat(exists).isTrue();
    }
}