package com.sprint.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.food_delivery.entity.Coupons;

public interface CouponsRepository  extends JpaRepository<Coupons, Integer>{

}
