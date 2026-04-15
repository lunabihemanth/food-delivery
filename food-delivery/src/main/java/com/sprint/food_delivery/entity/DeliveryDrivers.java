package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

public class DeliveryDrivers {
	
	@Id
    @Column(name = "driver_id")
    private Integer driverId;

    public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public String getDriverVehicle() {
		return driverVehicle;
	}
	public void setDriverVehicle(String driverVehicle) {
		this.driverVehicle = driverVehicle;
	}
	private String driverName;
    private String driverPhone;
    private String driverVehicle;
}
