package com.sprint.food_delivery.OrderModule.Orders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.CustomersModule.Customers.*;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.*;
import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.*;

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    private OrdersRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    @Autowired
    private DeliveryDriversRepository driversRepository;

    // CREATE
    @Override
    public OrdersResponseDTO save(OrdersRequestDTO dto) {

        Orders order = new Orders();
        order.setOrderDate(LocalDateTime.now());

        order.setCustomer(customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")));

        order.setRestaurant(restaurantsRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));

        if (dto.getDeliveryDriverId() != null) {
            order.setDeliveryDriver(driversRepository.findById(dto.getDeliveryDriverId())
                    .orElseThrow(() -> new RuntimeException("Driver not found")));
        }

        order.setOrderStatus(dto.getOrderStatus());

        return map(repository.save(order));
    }

    // GET ALL
    @Override
    public List<OrdersResponseDTO> getAll() {
        return repository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public OrdersResponseDTO findById(Integer id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found")));
    }

    // GET BY CUSTOMER
    @Override
    public List<OrdersResponseDTO> getByCustomerId(Integer customerId) {
        return repository.findByCustomer_CustomerId(customerId)
                .stream().map(this::map).collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public OrdersResponseDTO update(Integer id, OrdersRequestDTO dto) {

        Orders existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existing.setOrderStatus(dto.getOrderStatus());

        return map(repository.save(existing));
    }

    // DELETE
    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        repository.deleteById(id);
    }

    private OrdersResponseDTO map(Orders o) {
        return new OrdersResponseDTO(
                o.getOrderId(),
                o.getOrderDate(),
                o.getCustomer().getCustomerId(),
                o.getRestaurant().getRestaurantId(),
                o.getDeliveryDriver() != null ? o.getDeliveryDriver().getDriverId() : null,
                o.getOrderStatus()
        );
    }
}