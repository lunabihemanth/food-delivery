package com.sprint.food_delivery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import com.sprint.food_delivery.CustomersModule.Customers.*;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.*;
import com.sprint.food_delivery.RestaurantsModule.MenuItems.*;
import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.*;
import com.sprint.food_delivery.OrderModule.Orders.*;

@SpringBootTest
@Transactional
@Rollback(false)
public class DataInsertAllTablesTest {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRestaurantsService restaurantsService;

    @Autowired
    private IMenuItemsService menuItemsService;

    @Autowired
    private IDeliveryDriversService driversService;

    @Autowired
    private IOrdersService ordersService;

    @Test
    void insertAllData() {

        System.out.println("Starting Food Delivery Data Insert...");

        /*
        ---------- CUSTOMER ----------
        */
        CustomerRequestDTO customer = new CustomerRequestDTO();
        customer.setCustomerName("Lunabi");
        customer.setCustomerEmail("lunabi@test.com");
        customer.setCustomerPhone("9999999999");

        CustomerResponseDTO savedCustomer = customerService.save(customer);

        /*
        ---------- RESTAURANT ----------
        */
        RestaurantsRequestDTO restaurant = new RestaurantsRequestDTO();
        restaurant.setRestaurantName("Spicy Hub");
        restaurant.setRestaurantAddress("Mumbai");
        restaurant.setRestaurantPhone("8888888888");

        RestaurantResponseDTO savedRestaurant = restaurantsService.save(restaurant);

        /*
        ---------- MENU ITEM ----------
        */
        MenuItemsRequestDTO item = new MenuItemsRequestDTO();
        item.setItemName("Burger");
        item.setItemDescription("Cheese Burger");
        item.setItemPrice(150.0);
        item.setRestaurantId(savedRestaurant.getRestaurantId());

        menuItemsService.save(item);

        /*
        ---------- DELIVERY DRIVER ----------
        */
        DeliveryDriversRequestDTO driver = new DeliveryDriversRequestDTO();
        driver.setDriverName("Ravi");
        driver.setDriverPhone("7777777777");
        driver.setDriverVehicle("Bike");

        DeliveryDriversResponseDTO savedDriver = driversService.save(driver);

        /*
        ---------- ORDER ----------
        */
        OrdersRequestDTO order = new OrdersRequestDTO();
        order.setCustomerId(savedCustomer.getCustomerId());
        order.setRestaurantId(savedRestaurant.getRestaurantId());
        order.setDriverId(savedDriver.getDriverId());
        order.setOrderStatus("PLACED");

        ordersService.save(order);

        System.out.println("All Food Delivery Data Inserted Successfully!");
    }
}