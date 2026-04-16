package com.sprint.food_delivery.OrderModule.OrderItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order-items")
public class OrderItemsController {

    @Autowired
    private OrderItemsService service;

    @PostMapping
    public OrderItems createItem(@Valid @RequestBody OrderItems item) {
        return service.saveOrderItem(item);
    }

    @GetMapping
    public List<OrderItems> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public OrderItems getItem(@PathVariable Integer id) {
        return service.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Integer id) {
        service.deleteItem(id);
        return "Item deleted successfully";
    }
}