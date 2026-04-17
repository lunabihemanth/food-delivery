package com.sprint.food_delivery.CheckoutModule.Coupons;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private ICouponService couponService;

    // helper method
    private Map<String, Object> buildResponse(int status, String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    // ✅ CREATE COUPON
    @PostMapping
    public ResponseEntity<Map<String, Object>> createCoupon(
            @Valid @RequestBody CouponRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buildResponse(201, "Coupon created successfully",
                        couponService.save(dto)));
    }

    // ✅ GET ALL COUPONS
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCoupons() {

        return ResponseEntity.ok(
                buildResponse(200, "Coupons fetched successfully",
                        couponService.getAll())
        );
    }

    // ✅ VALIDATE COUPON (BY CODE)
    @GetMapping("/{couponCode}")
    public ResponseEntity<Map<String, Object>> validateCoupon(
            @PathVariable String couponCode) {

        return ResponseEntity.ok(
                buildResponse(200, "Coupon validated successfully",
                        couponService.findByCode(couponCode))
        );
    }

    // ✅ UPDATE COUPON
    @PutMapping("/{couponId}")
    public ResponseEntity<Map<String, Object>> updateCoupon(
            @PathVariable Integer couponId,
            @Valid @RequestBody CouponRequestDTO dto) {

        return ResponseEntity.ok(
                buildResponse(200, "Coupon updated successfully",
                        couponService.update(couponId, dto))
        );
    }

    // ✅ DELETE COUPON
    @DeleteMapping("/{couponId}")
    public ResponseEntity<Map<String, Object>> deleteCoupon(
            @PathVariable Integer couponId) {

        couponService.delete(couponId);

        return ResponseEntity.ok(
                buildResponse(200, "Coupon deleted successfully", null)
        );
    }
}