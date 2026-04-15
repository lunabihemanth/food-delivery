package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.DeliveryDrivers;
import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.DeliveryDriversRepository;

@SpringBootTest
public class DeliveryDriverTest {
    
    @Autowired
    private DeliveryDriversRepository repo;

    @Test
    void testCreateDeliveryDriver() {
        // Create a new delivery driver
        DeliveryDrivers d = new DeliveryDrivers();
        d.setDriverName("John Doe");
        d.setDriverPhone("9876543210");
        d.setDriverVehicle("Bike");

        DeliveryDrivers saved = repo.save(d);
    }

    @Test
    void testCreateDeliveryDriver01() {
        // Create a new delivery driver
        DeliveryDrivers d = new DeliveryDrivers();
        d.setDriverName("kisol");
        d.setDriverPhone("9876358710");
        d.setDriverVehicle("Car");

        DeliveryDrivers saved = repo.save(d);
    }


}
