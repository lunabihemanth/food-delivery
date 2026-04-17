package com.sprint.food_delivery.CheckoutModule.OrdersCoupons;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.CheckoutModule.Coupons.*;
import com.sprint.food_delivery.OrderModule.Orders.*;

@Service
public class OrdersCouponsService implements IOrdersCouponsService {

    @Autowired
    private OrdersCouponsRepository ordersCouponsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CouponsRepository couponsRepository;

    //Apply Coupon
    @Override
    public OrdersCouponsResponseDTO applyCoupon(OrdersCouponsRequestDTO dto) {

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Coupons coupon = couponsRepository.findById(dto.getCouponId())
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        OrdersCouponsId id = new OrdersCouponsId(dto.getOrderId(), dto.getCouponId());

        OrdersCoupons entity = new OrdersCoupons();
        entity.setId(id);
        entity.setOrder(order);
        entity.setCoupon(coupon);

        OrdersCoupons saved = ordersCouponsRepository.save(entity);

        return map(saved);
    }

    // GET ALL COUPONS FOR ORDER
    @Override
    public List<OrdersCouponsResponseDTO> getCouponsByOrderId(Integer orderId) {

        return ordersCouponsRepository.findByOrder_OrderId(orderId)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    //  REMOVE COUPON
    @Override
    public String removeCoupon(Integer orderId, Integer couponId) {

        OrdersCouponsId id = new OrdersCouponsId(orderId, couponId);

        ordersCouponsRepository.deleteById(id);
        return "Coupon id removed";
    }

    //  MAPPER
    private OrdersCouponsResponseDTO map(OrdersCoupons oc) {
        return new OrdersCouponsResponseDTO(
                oc.getOrder().getOrderId(),
                oc.getCoupon().getCouponId()
        );
    }
}