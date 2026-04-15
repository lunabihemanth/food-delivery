package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
<<<<<<< HEAD
=======

>>>>>>> 1c508e256c765be8bb706072d32cc2a111cfea0c
public class DeliveryDrivers {

    @Id
    @Column(name = "driver_id")
    private Integer driverId;

    @NotBlank(message = "Driver name cannot be empty")
    private String driverName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
=======
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
>>>>>>> 1c508e256c765be8bb706072d32cc2a111cfea0c
