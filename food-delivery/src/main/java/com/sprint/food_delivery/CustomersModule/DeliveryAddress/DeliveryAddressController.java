package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/addresses")
public class DeliveryAddressController {

    @Autowired
    private IDeliveryAddressService deliveryAddressService;

    @PostMapping
    public ResponseEntity<DeliveryAddress> create(@Valid @RequestBody DeliveryAddressDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryAddressService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryAddress>> getAll() {
        return ResponseEntity.ok(deliveryAddressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryAddress> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(deliveryAddressService.getById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<DeliveryAddress>> getByCustomerId(@PathVariable Integer customerId) {
        return ResponseEntity.ok(deliveryAddressService.getByCustomerId(customerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryAddress> update(@PathVariable Integer id,
                                                   @Valid @RequestBody DeliveryAddressDTO dto) {
        return ResponseEntity.ok(deliveryAddressService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deliveryAddressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}