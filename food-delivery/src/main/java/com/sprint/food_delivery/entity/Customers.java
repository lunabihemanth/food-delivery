package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
<<<<<<< HEAD
=======

@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customers")
>>>>>>> 1c508e256c765be8bb706072d32cc2a111cfea0c
public class Customers {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    @Email(message = "Invalid email format")
    private String email;

<<<<<<< HEAD
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
=======
    public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Column(name = "customer_phone")
    private String customerPhone;
>>>>>>> 1c508e256c765be8bb706072d32cc2a111cfea0c
}