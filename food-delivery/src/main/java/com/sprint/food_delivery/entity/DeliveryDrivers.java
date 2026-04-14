package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class DeliveryDrivers {
	
	@Id
    @Column(name = "driver_id")
    private Integer driverId;

    private String driverName;
    private String driverPhone;
    private String driverVehicle;
}
