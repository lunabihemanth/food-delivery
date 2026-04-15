package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.RestaurantsModule.MenuItems.MenuItems;
import com.sprint.food_delivery.RestaurantsModule.MenuItems.MenuItemsRepository;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.RestaurantsRepository;

@SpringBootTest
public class MenuItemTest {
    
    @Autowired
    private MenuItemsRepository menuRepo;

    @Autowired
    private RestaurantsRepository restaurantRepo;

    @Test
    void testCreateMenuItem() {

        Restaurants r = new Restaurants();
        r.setRestaurantName("pizza hut");
        r.setRestaurantAddress("19 marina St");
        r.setRestaurantPhone("8805741824");

        r = restaurantRepo.save(r);

        MenuItems item = new MenuItems();
        item.setItemName("Pizza");
        item.setDescription("Thin Crust cheese pizza");
        item.setPrice(290.99);
        item.setRestaurant(r);

        MenuItems saved = menuRepo.save(item);
    }
}
