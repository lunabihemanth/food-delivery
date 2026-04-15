package com.sprint.food_delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.OrderItems;
import com.sprint.food_delivery.repository.OrderItemRepository;

@Service
public class OrderItemsService {
	@Autowired
	private OrderItemRepository orderItemRepository;

public OrderItems save(OrderItems orderItems) {
	return orderItemRepository.save(orderItems);
}

public List<OrderItems> getAll()
{
	return orderItemRepository.findAll();
}

public OrderItems updateById(Integer id,OrderItems orderItems)
{
	OrderItems existing=orderItemRepository.findById(id).orElseThrow(()->
	new RuntimeException("OrderItem not found"));
	
	
		existing.setQuantity(orderItems.getQuantity());
		existing.setMenuItem(orderItems.getMenuItem());
		existing.setOrder(orderItems.getOrder());
		
		return orderItemRepository.save(existing);
	
}

public void delete(Integer id)
{
	orderItemRepository.deleteById(id);
	System.out.println("Deleted this item:"+id);
}
}
