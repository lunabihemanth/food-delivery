package com.sprint.food_delivery.CustomersModule.Customers;

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
@RequestMapping("/customers")  
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(
            @Valid @RequestBody CustomerRequestDTO customerDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.save(customerDTO));
    }

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    // GET BY ID
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO> findById(
            @PathVariable Integer customerId) {

        return ResponseEntity.ok(customerService.findById(customerId));
    }

    // UPDATE
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO> update(
            @PathVariable Integer customerId,
            @Valid @RequestBody CustomerRequestDTO customerDTO) {

        return ResponseEntity.ok(
                customerService.update(customerId, customerDTO)
        );
    }

    // DELETE
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable Integer customerId) {
        customerService.delete(customerId);
        return ResponseEntity.noContent().build();
    }
}