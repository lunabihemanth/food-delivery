package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddressDTO {

    @NotBlank(message = "Address line 1 cannot be empty")
    private String addressLine1;

    private String addressLine2; // optional

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "State cannot be empty")
    private String state;

    @NotBlank(message = "Postal code cannot be empty")
    private String postalCode;

    @NotNull(message = "Customer ID cannot be null")
    private Integer customerId; // only accept ID, not the whole Customer object
}
