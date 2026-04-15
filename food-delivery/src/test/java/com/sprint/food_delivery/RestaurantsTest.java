package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.RestaurantsRepository;

@SpringBootTest
public class RestaurantsTest {

    @Autowired
    private RestaurantsRepository repo;

    @Test
    void testCreateRestaurant() {
        Restaurants r = new Restaurants();
        r.setRestaurantName("subway");
        r.setRestaurantAddress("123 annanagar St");
        r.setRestaurantPhone("8807675214");

        Restaurants saved = repo.save(r);
    }

    @Test
    void testCreateRestaurant01() {
        Restaurants r = new Restaurants();
        r.setRestaurantName("perfecto pizza");
        r.setRestaurantAddress("23 annasalai St");
        r.setRestaurantPhone("2534914254");

        Restaurants saved = repo.save(r);
    }
    
}
