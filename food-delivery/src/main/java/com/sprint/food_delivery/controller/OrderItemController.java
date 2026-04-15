package com.sprint.food_delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.food_delivery.entity.OrderItems;
import com.sprint.food_delivery.service.OrderItemsService;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
	
	@Autowired
	private OrderItemsService orderitemService;
	
	@PostMapping("/saveOrderItem")
public OrderItems save(@RequestBody OrderItems order)
{
	return orderitemService.save(order);
}

	@GetMapping("/getAllOrderItem")
public List<OrderItems> getAll()
{
	return orderitemService.getAll();
}

	@PutMapping("/updateOrderItem/{id}")
public OrderItems update(@PathVariable Integer id,@RequestBody OrderItems order) {
	return orderitemService.updateById(id, order);
}

	@DeleteMapping("/deleteOrderItem/{id}")
public void delete(@PathVariable Integer id)
{
	orderitemService.delete(id);
}
}
