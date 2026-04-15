package com.sprint.food_delivery.RestaurantsModule.Restaurants;

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

import com.sprint.food_delivery.entity.Restaurants;
import com.sprint.food_delivery.service.RestaurantService;



@RestController
	@RequestMapping("/restaurant")
	public class RestaurantController {
	    @Autowired
	    private RestaurantService restaurantService;

	    @PostMapping("/add1")
	    public Restaurants save(@RequestBody Restaurants restaurant) {
	        return restaurantService.save(restaurant);
	    }
	    @GetMapping("/getAll")
	    public List<Restaurants> getAll() {
	        return restaurantService.getAll();
	    }
	    @GetMapping("/findbyid/{id}")
	    public Restaurants findById(@PathVariable Integer id) {
	        return restaurantService.findById(id);
	    }
	    @PutMapping("/update/{id}")
	    public Restaurants update(@PathVariable Integer id, @RequestBody Restaurants restaurant) {
	        return restaurantService.update(id, restaurant);
	    }
	    @DeleteMapping("/delete/{id}")
	    public void delete(@PathVariable Integer id) {
	        restaurantService.delete(id);
	    }
	}

