package com.sprint.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.food_delivery.entity.Coupons;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupons, Integer> {

    Optional<Coupons> findByCouponCode(String couponCode);
}