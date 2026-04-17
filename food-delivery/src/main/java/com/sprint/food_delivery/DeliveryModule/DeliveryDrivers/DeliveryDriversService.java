package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;
import java.util.List;

import com.sprint.food_delivery.OrderModule.Orders.Orders;
public interface DeliveryDriversService {

     DeliveryDrivers save(DeliveryDrivers driver);

    List<DeliveryDrivers> getAll();

    DeliveryDrivers findById(Integer id);

    DeliveryDrivers update(Integer id, DeliveryDrivers driver);

    void delete(Integer id);

    String assignDriverToOrder(Integer orderId, Integer driverId);

    List<Orders> getOrdersByDriver(Integer driverId);

    String updateDeliveryStatus(Integer orderId, String status);
}
