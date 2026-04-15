package com.sprint.food_delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.Coupons;
import com.sprint.food_delivery.repository.CouponsRepository;


@Service
public class CouponsService {

	@Autowired
	private CouponsRepository couponRepository;
	 public Coupons save(Coupons coupon) {
	        return couponRepository.save(coupon);
	    }
	    public List<Coupons> getAll() {
	        return couponRepository.findAll();
	    }
	    public Coupons findById(Integer id) {
	        return couponRepository.findById(id).orElse(null);
	    }
	    public Coupons update(Integer id, Coupons coupon) {
	        Coupons existing = couponRepository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setCouponCode(coupon.getCouponCode());
	            existing.setDiscountAmount(coupon.getDiscountAmount());
	            existing.setExpiryDate(coupon.getExpiryDate());
	            return couponRepository.save(existing);
	        }
	        return null;
	    }
	    public void delete(Integer id) {
	        couponRepository.deleteById(id);
	        System.out.println("Deleted coupon: " + id);
	    }
	}


