package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.DeliveryDrivers;
import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.DeliveryDriverRepository;

@SpringBootTest
public class DeliveryDriverTest {

    @Autowired
    private DeliveryDriverRepository repo;

    @Test
    void testCreateDeliveryDriver() {

        DeliveryDrivers d = new DeliveryDrivers();
        d.setDriverName("John Doe");
        d.setDriverPhone("9876543210");
        d.setDriverVehicle("Bike");

        repo.save(d);
    }

    @Test
    void testCreateDeliveryDriver01() {

        DeliveryDrivers d = new DeliveryDrivers();
        d.setDriverName("kisol");
        d.setDriverPhone("9876358710");
        d.setDriverVehicle("Car");

        repo.save(d);
    }
}