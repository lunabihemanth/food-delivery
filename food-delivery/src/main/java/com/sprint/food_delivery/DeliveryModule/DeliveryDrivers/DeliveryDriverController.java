package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.food_delivery.OrderModule.Orders.Orders;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/drivers")
public class DeliveryDriverController {

    @Autowired
    private DeliveryDriversService driverService;

    @PostMapping("/add")
    public DeliveryDrivers save(@Valid @RequestBody DeliveryDrivers driver) {
        return driverService.save(driver);
    }

  
    @GetMapping
    public List<DeliveryDrivers> getAll() {
        return driverService.getAll();
    }

  
    @GetMapping("/{id}")
    public DeliveryDrivers findById(@PathVariable Integer id) {
        return driverService.findById(id);
    }

    
    @PutMapping("/{id}")
    public DeliveryDrivers update(@PathVariable Integer id, @RequestBody DeliveryDrivers driver) {
        return driverService.update(id, driver);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        driverService.delete(id);
    }

  
    @PutMapping("/assign/{orderId}/{driverId}")
    public String assignDriver(@PathVariable Integer orderId, @PathVariable Integer driverId) {
        return driverService.assignDriverToOrder(orderId, driverId);
    }

    
    @GetMapping("/{driverId}/orders")
    public List<Orders> getOrdersByDriver(@PathVariable Integer driverId) {
        return driverService.getOrdersByDriver(driverId);
    }

    
    @PutMapping("/status/{orderId}")
    public String updateStatus(@PathVariable Integer orderId, @RequestBody String status) {
        return driverService.updateDeliveryStatus(orderId, status);
    }
}