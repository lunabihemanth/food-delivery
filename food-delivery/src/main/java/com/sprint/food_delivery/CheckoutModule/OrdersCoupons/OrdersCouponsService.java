package com.sprint.food_delivery.CheckoutModule.OrdersCoupons;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.CheckoutModule.Coupons.Coupons;
import com.sprint.food_delivery.CheckoutModule.Coupons.CouponsRepository;
import com.sprint.food_delivery.OrderModule.OrderItems.OrderItemsRepository;
import com.sprint.food_delivery.OrdersModule.Orders.Orders;
import com.sprint.food_delivery.OrdersModule.Orders.OrdersRepository;

@Service
public class OrdersCouponsService implements IOrdersCouponsService {

    @Autowired
    private OrdersCouponsRepository ordersCouponsRepository;

    @Autowired
    private OrderItemsRepository ordersRepository;

    @Autowired
    private CouponsRepository couponsRepository;

    // ✅ APPLY COUPON TO ORDER
    @Override
    public OrdersCouponsResponseDTO applyCoupon(OrdersCouponsRequestDTO dto) {

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Coupons coupon = couponsRepository.findById(dto.getCouponId())
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        // 🔥 Business validation (important)
        if (coupon.getExpiryDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Coupon has expired");
        }

        // prevent duplicate application
        OrdersCouponsId id = new OrdersCouponsId(dto.getOrderId(), dto.getCouponId());
        if (ordersCouponsRepository.existsById(id)) {
            throw new RuntimeException("Coupon already applied to this order");
        }

        OrdersCoupons entity = new OrdersCoupons();
        entity.setId(id);
        entity.setOrder(order);
        entity.setCoupon(coupon);

        ordersCouponsRepository.save(entity);

        return new OrdersCouponsResponseDTO(
                dto.getOrderId(),
                dto.getCouponId()
        );
    }

    // ✅ GET ALL COUPONS APPLIED TO AN ORDER
    @Override
    public List<OrdersCouponsResponseDTO> getCouponsByOrderId(Integer orderId) {

        if (!ordersRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }

        return ordersCouponsRepository.findByOrder_OrderId(orderId)
                .stream()
                .map(oc -> new OrdersCouponsResponseDTO(
                        oc.getOrder().getOrderId(),
                        oc.getCoupon().getCouponId()
                ))
                .collect(Collectors.toList());
    }

    // ✅ REMOVE COUPON FROM ORDER
    @Override
    public void removeCoupon(Integer orderId, Integer couponId) {

        OrdersCouponsId id = new OrdersCouponsId(orderId, couponId);

        if (!ordersCouponsRepository.existsById(id)) {
            throw new RuntimeException("Coupon not applied to this order");
        }

        ordersCouponsRepository.deleteById(id);
    }
}