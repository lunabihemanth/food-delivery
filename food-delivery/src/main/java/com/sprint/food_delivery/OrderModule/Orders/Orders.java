package com.sprint.food_delivery.OrderModule.Orders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.sprint.food_delivery.CheckoutModule.OrdersCoupons.OrdersCoupons;
import com.sprint.food_delivery.CustomersModule.Customers.Customers;
import com.sprint.food_delivery.DeliveryModule.DeliveryDrivers.DeliveryDrivers;
import com.sprint.food_delivery.OrderModule.OrderItems.OrderItems;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @NotNull(message = "Order date cannot be null")
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @NotBlank(message = "Order status cannot be empty")
    @Column(name = "order_status") 
    private String orderStatus;

   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private DeliveryDrivers deliveryDriver;

    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

    
    @OneToMany(mappedBy = "order")
    private Set<OrdersCoupons> orderCoupons;

    @PrePersist
    public void prePersist() {
        if (this.orderDate == null) {
            this.orderDate = LocalDateTime.now();
        }
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public DeliveryDrivers getDeliveryDriver() {
        return deliveryDriver;
    }

    public void setDeliveryDriver(DeliveryDrivers deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<OrdersCoupons> getOrderCoupons() {
        return orderCoupons;
    }

    public void setOrderCoupons(Set<OrdersCoupons> orderCoupons) {
        this.orderCoupons = orderCoupons;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}