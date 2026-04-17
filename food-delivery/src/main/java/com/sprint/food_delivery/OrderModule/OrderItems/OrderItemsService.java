package com.sprint.food_delivery.OrderModule.OrderItems;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.OrderModule.Orders.Orders;
import com.sprint.food_delivery.OrderModule.Orders.OrdersRepository;
import com.sprint.food_delivery.RestaurantsModule.MenuItems.MenuItems;
import com.sprint.food_delivery.RestaurantsModule.MenuItems.MenuItemsRepository;

@Service
public class OrderItemsService implements IOrderItemsService {

    @Autowired
    private OrderItemsRepository repository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private MenuItemsRepository menuItemsRepository;

    // CREATE
    @Override
    public OrderItemsResponseDTO save(OrderItemsRequestDTO dto) {

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        MenuItems item = menuItemsRepository.findById(dto.getItemId())
                .orElseThrow(() -> new RuntimeException("Menu Item not found"));

        OrderItems oi = new OrderItems();
        oi.setQuantity(dto.getQuantity());
        oi.setOrder(order);
        oi.setMenuItem(item);

        OrderItems saved = repository.save(oi);

        return new OrderItemsResponseDTO(
                saved.getOrderItemId(),
                saved.getQuantity(),
                saved.getOrder().getOrderId(),
                saved.getMenuItem().getItemId()
        );
    }

    // GET ALL
    @Override
    public List<OrderItemsResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(oi -> new OrderItemsResponseDTO(
                        oi.getOrderItemId(),
                        oi.getQuantity(),
                        oi.getOrder().getOrderId(),
                        oi.getMenuItem().getItemId()))
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public OrderItemsResponseDTO findById(Integer id) {
        OrderItems oi = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        return new OrderItemsResponseDTO(
                oi.getOrderItemId(),
                oi.getQuantity(),
                oi.getOrder().getOrderId(),
                oi.getMenuItem().getItemId()
        );
    }

    // UPDATE
    @Override
    public OrderItemsResponseDTO update(Integer id, OrderItemsRequestDTO dto) {

        OrderItems existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        MenuItems item = menuItemsRepository.findById(dto.getItemId())
                .orElseThrow(() -> new RuntimeException("Menu Item not found"));

        existing.setQuantity(dto.getQuantity());
        existing.setOrder(order);
        existing.setMenuItem(item);

        OrderItems updated = repository.save(existing);

        return new OrderItemsResponseDTO(
                updated.getOrderItemId(),
                updated.getQuantity(),
                updated.getOrder().getOrderId(),
                updated.getMenuItem().getItemId()
        );
    }

    // DELETE
    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("OrderItem not found");
        }
        repository.deleteById(id);
    }
}