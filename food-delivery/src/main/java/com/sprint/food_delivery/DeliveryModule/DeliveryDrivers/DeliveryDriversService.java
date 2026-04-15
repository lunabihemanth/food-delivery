package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.DeliveryDrivers;
import com.sprint.food_delivery.entity.Orders;
import com.sprint.food_delivery.repository.DeliveryDriversRepository;
import com.sprint.food_delivery.repository.OrderRepository;

@Service
public class DeliveryDriversService {

	@Autowired
	private DeliveryDriversRepository driverRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	  public DeliveryDrivers save(DeliveryDrivers driver) {
	        return driverRepository.save(driver);
	    }

	    public List<DeliveryDrivers> getAll() {
	        return driverRepository.findAll();
	    }

	    public DeliveryDrivers findById(Integer id) {
	        return driverRepository.findById(id).orElse(null);
	    }

	    public DeliveryDrivers update(Integer id, DeliveryDrivers driver) {
	        DeliveryDrivers existing = driverRepository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setDriverName(driver.getDriverName());
	            existing.setDriverPhone(driver.getDriverPhone());
	            existing.setDriverVehicle(driver.getDriverVehicle());
	            return driverRepository.save(existing);
	        }
	        return null;
	    }

	    public void delete(Integer id) {
	        driverRepository.deleteById(id);
	    }


	    public String assignDriverToOrder(Integer orderId, Integer driverId) {
	        Orders order = orderRepository.findById(orderId).orElse(null);
	        DeliveryDrivers driver = driverRepository.findById(driverId).orElse(null);
	        if (order != null && driver != null) {
	            order.setDeliveryDriver(driver);
	            orderRepository.save(order);
	            return "Driver " + driverId + " assigned to Order " + orderId;
	        }
	        return "Order or Driver not found.";
	    }


	    public List<Orders> getOrdersByDriver(Integer driverId) {
	        return orderRepository.findByDeliveryDriverDriverId(driverId);
	    }

	    public String updateDeliveryStatus(Integer orderId, String status) {
	        Orders order = orderRepository.findById(orderId).orElse(null);
	        if (order != null) {
	            order.setOrderStatus(status);
	            orderRepository.save(order);
	            return "Order " + orderId + " status updated to: " + status;
	        }
	        return "Order not found.";
	    }
	}
	

