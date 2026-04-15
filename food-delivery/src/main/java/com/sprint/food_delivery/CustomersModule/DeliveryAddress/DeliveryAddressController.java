package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService service;

    @PostMapping
    public DeliveryAddress create(@RequestBody DeliveryAddress address) {
        return service.save(address);
    }

    @GetMapping
    public List<DeliveryAddress> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryAddress getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public DeliveryAddress update(@PathVariable Integer id,
                                  @RequestBody DeliveryAddress address) {
        return service.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
