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

import com.sprint.food_delivery.entity.Orders;
import com.sprint.food_delivery.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add")
public Orders saveAll(@RequestBody Orders orders)
{
	return orderService.saveOrder(orders);
}

	@GetMapping("/getAll")
public List<Orders> getAllOrder()
{
	return orderService.getAll();
}

	@PutMapping("/update/{id}")
public Orders updateorder(@PathVariable Integer id,@RequestBody Orders order)
{
	return orderService.updateOrder(id, order);
}

	@GetMapping("/findbyid/{id}")
public Orders findbyId(@PathVariable Integer id)
{
	return orderService.findById(id);
}

	@DeleteMapping("/delete/{id}")
public void deleteorder(@PathVariable Integer id)
{
	 orderService.delete(id);
}
}
