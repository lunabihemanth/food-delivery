package com.sprint.food_delivery.OrderModule.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService ordersService;

    @PostMapping
    public Orders createOrder(@Valid @RequestBody Orders order) {
        return ordersService.saveOrder(order);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Integer id) {
        return ordersService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
        return "Order deleted successfully";
    }
}