package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import com.sprint.food_delivery.OrderModule.Orders.OrderRepository;
import com.sprint.food_delivery.OrderModule.Orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryDriversServiceImpl implements DeliveryDriversService {

    @Autowired
    private DeliveryDriversRepository driverRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public DeliveryDrivers save(DeliveryDrivers driver) {
        return driverRepository.save(driver);
    }

    @Override
    public List<DeliveryDrivers> getAll() {
        return driverRepository.findAll();
    }

    @Override
    public DeliveryDrivers findById(Integer id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

    @Override
    public DeliveryDrivers update(Integer id, DeliveryDrivers driver) {
        DeliveryDrivers existing = findById(id);
        existing.setDriverName(driver.getDriverName());
        existing.setDriverPhone(driver.getDriverPhone());
        existing.setDriverVehicle(driver.getDriverVehicle());
        return driverRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        driverRepository.deleteById(id);
    }

    @Override
    public String assignDriverToOrder(Integer orderId, Integer driverId) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        // Order must be Pending to assign driver
        if (!order.getOrderStatus().equals("Pending")) {
            throw new RuntimeException(
                "Driver can only be assigned to Pending orders. Current status: "
                + order.getOrderStatus());
        }

        DeliveryDrivers driver = findById(driverId);
        order.setDeliveryDriver(driver);
        order.setOrderStatus("Assigned");
        orderRepository.save(order);

        return "Driver " + driverId + " assigned to Order " + orderId;
    }

    @Override
    public List<Orders> getOrdersByDriver(Integer driverId) {
        findById(driverId); // validate driver exists
        return orderRepository.findByDeliveryDriverDriverId(driverId);
    }

    @Override
    public String updateDeliveryStatus(Integer orderId, String status) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        // Only allowed delivery statuses
        if (!status.equals("Out for Delivery") && !status.equals("Delivered")) {
            throw new RuntimeException(
                "Delivery status must be 'Out for Delivery' or 'Delivered'.");
        }

        order.setOrderStatus(status);
        orderRepository.save(order);

        return "Order " + orderId + " status updated to: " + status;
    }
}