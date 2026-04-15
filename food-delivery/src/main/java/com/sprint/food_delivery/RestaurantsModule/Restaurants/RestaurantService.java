package com.sprint.food_delivery.RestaurantsModule.Restaurants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.Restaurants;
import com.sprint.food_delivery.repository.RestaurantsRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantsRepository restaurantRepository;
	  public Restaurants save(Restaurants restaurant) {
	        return restaurantRepository.save(restaurant);
	    }
	    public List<Restaurants> getAll() {
	        return restaurantRepository.findAll();
	    }
	    public Restaurants findById(Integer id) {
	        return restaurantRepository.findById(id).orElse(null);
	    }
	    public Restaurants update(Integer id, Restaurants restaurant) {
	        Restaurants existing = restaurantRepository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setRestaurantName(restaurant.getRestaurantName());
	            existing.setRestaurantAddress(restaurant.getRestaurantAddress());
	            existing.setRestaurantPhone(restaurant.getRestaurantPhone());
	            return restaurantRepository.save(existing);
	        }
	        return null;
	    }
	    public void delete(Integer id) {
	        restaurantRepository.deleteById(id);
	        System.out.println("Deleted restaurant: " + id);
	    }
	}

	


