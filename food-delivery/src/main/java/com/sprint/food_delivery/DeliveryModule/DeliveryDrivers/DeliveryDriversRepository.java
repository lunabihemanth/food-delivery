package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryDriversRepository extends JpaRepository<DeliveryDrivers, Integer> {

    // custom — find drivers by vehicle type (Car / Bike / Scooter)
    @Query("SELECT d FROM DeliveryDrivers d WHERE d.driverVehicle = :vehicle")
    List<DeliveryDrivers> findByVehicle(@Param("vehicle") String vehicle);

    // custom — search driver by partial name
    @Query("SELECT d FROM DeliveryDrivers d WHERE LOWER(d.driverName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<DeliveryDrivers> searchByName(@Param("name") String name);

    // custom — find driver by phone number
    @Query("SELECT d FROM DeliveryDrivers d WHERE d.driverPhone = :phone")
    DeliveryDrivers findByPhone(@Param("phone") String phone);
}
