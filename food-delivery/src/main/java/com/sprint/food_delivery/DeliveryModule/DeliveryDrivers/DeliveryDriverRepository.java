package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DeliveryDriverRepository extends JpaRepository<DeliveryDrivers, Integer> {

    boolean existsByDriverPhone(String driverPhone);

    Optional<DeliveryDrivers> findByDriverPhone(String driverPhone);

    @Query("SELECT d FROM DeliveryDrivers d WHERE LOWER(d.driverName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<DeliveryDrivers> searchByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE DeliveryDrivers d SET d.driverName = :name, d.driverPhone = :phone, d.driverVehicle = :vehicle WHERE d.driverId = :id")
    int updateDriverDetails(@Param("id") Integer id,
                            @Param("name") String name,
                            @Param("phone") String phone,
                            @Param("vehicle") String vehicle);
}