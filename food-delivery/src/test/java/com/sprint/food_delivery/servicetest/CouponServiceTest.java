package com.sprint.food_delivery.servicetest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.food_delivery.CheckoutModule.Coupons.ICouponService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class CouponServiceTest {

    @Autowired
    private ICouponService couponService;

    // ✅ POSITIVE TEST
    // @Test
    // void testSaveCouponSuccess() {
    //     CouponRequestDTO dto = new CouponRequestDTO();
    //     dto.setCouponCode("TEST" + System.currentTimeMillis()); // avoid duplicate
    //     dto.setDiscountAmount(10.0);
    //     dto.setExpiryDate(LocalDate.now().plusDays(5));

    //     CouponResponseDTO response = couponService.save(dto);

    //     assertNotNull(response);
    //     assertEquals(dto.getCouponCode(), response.getCouponCode());
    // }

    // ❌ NEGATIVE TEST
    // @Test
    // void testSaveCouponInvalidDiscount() {
    //     CouponRequestDTO dto = new CouponRequestDTO();
    //     dto.setCouponCode("INVALID" + System.currentTimeMillis());
    //     dto.setDiscountAmount(10); // invalid
    //     dto.setExpiryDate(LocalDate.now().plusDays(5));

    //     assertThrows(Exception.class, () -> {
    //         couponService.save(dto);
    //     });
    // }
}