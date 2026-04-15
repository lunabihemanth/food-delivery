package com.sprint.food_delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.Orders;
import com.sprint.food_delivery.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

public Orders saveOrder(Orders orders)
{
	return orderRepository.save(orders);
}

public List<Orders> getAll()
{
	return orderRepository.findAll();
}

public Orders updateOrder(Integer id,Orders updateorder)
{
	Orders existingorder=orderRepository.findById(id).orElse(null);
	if(existingorder!=null)
	{
		    existingorder.setOrderDate(updateorder.getOrderDate());
	        existingorder.setOrderStatus(updateorder.getOrderStatus());
	        existingorder.setCustomer(updateorder.getCustomer());
	        existingorder.setRestaurant(updateorder.getRestaurant());
	        existingorder.setDeliveryDriver(updateorder.getDeliveryDriver());

	        return orderRepository.save(existingorder);
	}
	
	return null;
}

public Orders findById(Integer id)
{
	return orderRepository.findById(id).orElse(null);

}
public void delete(Integer id)
{
	orderRepository.deleteById(id);
	System.out.println("Deleted this order: "+id);
}

}
