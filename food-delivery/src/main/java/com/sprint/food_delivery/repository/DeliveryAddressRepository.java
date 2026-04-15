package com.sprint.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.food_delivery.entity.DeliveryAddresses;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddresses, Integer> {
}