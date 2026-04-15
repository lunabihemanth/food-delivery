package com.sprint.food_delivery.controller;

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

import com.sprint.food_delivery.entity.DeliveryDrivers;
import com.sprint.food_delivery.service.DeliveryDriversService;

@RestController
	@RequestMapping("/driver")
	public class DeliveryDriverController {
	    @Autowired
	    private DeliveryDriversService driverService;

	    @PostMapping("/add")
	    public DeliveryDrivers save(@RequestBody DeliveryDrivers driver) {
	        return driverService.save(driver);
	    }
	    @GetMapping("/getAll")
	    public List<DeliveryDrivers> getAll() {
	        return driverService.getAll();
	    }
	    @GetMapping("/findbyid/{id}")
	    public DeliveryDrivers findById(@PathVariable Integer id) {
	        return driverService.findById(id);
	    }
	    @PutMapping("/update/{id}")
	    public DeliveryDrivers update(@PathVariable Integer id, @RequestBody DeliveryDrivers driver) {
	        return driverService.update(id, driver);
	    }
	    @DeleteMapping("/delete/{id}")
	    public void delete(@PathVariable Integer id) {
	        driverService.delete(id);
	    }
	}

