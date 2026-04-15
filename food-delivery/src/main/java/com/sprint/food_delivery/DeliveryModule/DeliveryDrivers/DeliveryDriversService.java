package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.OrderModule.Orders.OrderRepository;
import com.sprint.food_delivery.OrderModule.Orders.Orders;

@Service
public class DeliveryDriversService {

    @Autowired
    private DeliveryDriversRepository driverRepository;

    @Autowired
    private OrderRepository orderRepository;

    // CREATE
    public DeliveryDrivers save(DeliveryDrivers driver) {
        return driverRepository.save(driver);
    }

    // READ ALL
    public List<DeliveryDrivers> getAll() {
        return driverRepository.findAll();
    }

    // READ BY ID
    public DeliveryDrivers findById(Integer id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    // UPDATE
    public DeliveryDrivers update(Integer id, DeliveryDrivers driver) {
        DeliveryDrivers existing = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        existing.setDriverName(driver.getDriverName());
        existing.setDriverPhone(driver.getDriverPhone());
        existing.setDriverVehicle(driver.getDriverVehicle());

        return driverRepository.save(existing);
    }

    // DELETE
    public void delete(Integer id) {
        driverRepository.deleteById(id);
    }

    // ASSIGN DRIVER TO ORDER
    public String assignDriverToOrder(Integer orderId, Integer driverId) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DeliveryDrivers driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        order.setDeliveryDriver(driver);
        orderRepository.save(order);

        return "Driver " + driverId + " assigned to Order " + orderId;
    }

    // GET ORDERS BY DRIVER
    public List<Orders> getOrdersByDriver(Integer driverId) {
        return orderRepository.findByDeliveryDriverDriverId(driverId);
    }

    // UPDATE DELIVERY STATUS
    public String updateDeliveryStatus(Integer orderId, String status) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderStatus(status);
        orderRepository.save(order);

        return "Order " + orderId + " status updated to: " + status;
    }
}