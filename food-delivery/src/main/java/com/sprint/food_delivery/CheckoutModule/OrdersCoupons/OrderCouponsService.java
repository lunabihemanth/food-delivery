//package com.sprint.food_delivery.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sprint.food_delivery.entity.OrderCouponId;
//import com.sprint.food_delivery.entity.OrdersCoupons;
//import com.sprint.food_delivery.repository.OrderCouponIdRepository;
//
//@Service
//public class OrderCouponsService {
//	@Autowired
//	private OrderCouponIdRepository orderCouponRepository;
//	
//	 public OrdersCoupons save(OrdersCoupons orderCoupon) {
//	        return orderCouponRepository.save(orderCoupon);
//	    }
//	    public List<OrdersCoupons> getAll() {
//	        return orderCouponRepository.findAll();
//	    }
//	    public OrdersCoupons findById(OrderCouponId id) {
//	        return orderCouponRepository.findById(id).orElse(null);
//	    }
//	    public void delete(OrderCouponId id) {
//	        orderCouponRepository.deleteById(id);
//	        System.out.println("Deleted order-coupon mapping");
//	    }
//	}
//
