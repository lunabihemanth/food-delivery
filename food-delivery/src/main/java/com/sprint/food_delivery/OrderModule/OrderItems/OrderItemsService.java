package com.sprint.food_delivery.OrderModule.OrderItems;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public OrderItems saveOrderItem(OrderItems item) {
        return orderItemsRepository.save(item);
    }

    public List<OrderItems> getAllItems() {
        return orderItemsRepository.findAll();
    }

    public OrderItems getItemById(Integer id) {
        return orderItemsRepository.findById(id).orElse(null);
    }

    public void deleteItem(Integer id) {
        orderItemsRepository.deleteById(id);
    }
}