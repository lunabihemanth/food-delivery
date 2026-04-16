package com.sprint.food_delivery.OrderModule.Orders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository ordersRepository;

    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrderById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Integer id) {
        ordersRepository.deleteById(id);
    }
}