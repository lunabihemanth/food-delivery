package com.sprint.food_delivery.CheckoutModule.Coupons;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService implements ICouponService {

    @Autowired
    private CouponsRepository couponRepository;

    // CREATE
    @Override
    public CouponResponseDTO save(CouponRequestDTO dto) {

        Coupons coupon = new Coupons();
        coupon.setCouponId(dto.getCouponId());
        coupon.setCouponCode(dto.getCouponCode());
        coupon.setDiscountAmount(dto.getDiscountAmount());
        coupon.setExpiryDate(dto.getExpiryDate());

        Coupons saved = couponRepository.save(coupon);

        return mapToDTO(saved);
    }

    // GET ALL
    @Override
    public List<CouponResponseDTO> getAll() {
        return couponRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // GET BY CODE (VALIDATE COUPON)
    @Override
    public CouponResponseDTO findByCode(String couponCode) {

        Coupons coupon = couponRepository.findByCouponCode(couponCode)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        return mapToDTO(coupon);
    }

    // GET BY ID
    @Override
    public CouponResponseDTO findById(Integer couponId) {

        Coupons coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        return mapToDTO(coupon);
    }

    // UPDATE
    @Override
    public CouponResponseDTO update(Integer couponId, CouponRequestDTO dto) {

        Coupons existing = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        existing.setCouponCode(dto.getCouponCode());
        existing.setDiscountAmount(dto.getDiscountAmount());
        existing.setExpiryDate(dto.getExpiryDate());

        Coupons updated = couponRepository.save(existing);

        return mapToDTO(updated);
    }

    // DELETE
    @Override
    public void delete(Integer couponId) {

        if (!couponRepository.existsById(couponId)) {
            throw new RuntimeException("Coupon not found");
        }

        couponRepository.deleteById(couponId);
    }

    // 🔁 MAPPER METHOD
    private CouponResponseDTO mapToDTO(Coupons coupon) {
        return new CouponResponseDTO(
                coupon.getCouponId(),
                coupon.getCouponCode(),
                coupon.getDiscountAmount(),
                coupon.getExpiryDate()
        );
    }
}