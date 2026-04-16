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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customers> save(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customers>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Customers> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customers> update(@PathVariable Integer id,
                                            @Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.update(id, customerDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

