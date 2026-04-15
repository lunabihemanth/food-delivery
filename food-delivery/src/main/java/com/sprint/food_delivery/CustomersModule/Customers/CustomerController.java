package com.sprint.food_delivery.CustomersModule.Customers;

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

import com.sprint.food_delivery.CustomersModule.Customers.Customers;
import com.sprint.food_delivery.CustomersModule.Customers.CustomerService;

@RestController
	@RequestMapping("/customer")
	public class CustomerController {
	    @Autowired
	    private CustomerService customerService;

	    @PostMapping("/add")
	    public Customers save(@RequestBody Customers customer) {
	        return customerService.save(customer);
	    }
	    @GetMapping("/getAll")
	    public List<Customers> getAll() {
	        return customerService.getAll();
	    }
	    @GetMapping("/findbyid/{id}")
	    public Customers findById(@PathVariable Integer id) {
	        return customerService.findById(id);
	    }
	    @PutMapping("/update/{id}")
	    public Customers update(@PathVariable Integer id, @RequestBody Customers customer) {
	        return customerService.update(id, customer);
	    }
	    @DeleteMapping("/delete/{id}")
	    public void delete(@PathVariable Integer id) {
	        customerService.delete(id);
	    }
	}


