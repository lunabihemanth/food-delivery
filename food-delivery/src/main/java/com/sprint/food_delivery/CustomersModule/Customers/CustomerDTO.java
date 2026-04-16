package com.sprint.food_delivery.CustomersModule.Customers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String customerEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String customerPhone;
}
