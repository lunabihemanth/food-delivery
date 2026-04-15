package com.sprint.food_delivery.CheckoutModule.Coupons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupons, Integer> {

    Optional<Coupons> findByCouponCode(String couponCode);
}