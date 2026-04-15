package com.sprint.food_delivery.CheckoutModule.Coupons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sprint.food_delivery.CheckoutModule.Coupons.Coupons;
import com.sprint.food_delivery.CheckoutModule.Coupons.CouponRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CouponDataLoader {

    @Bean
    public org.springframework.boot.CommandLineRunner loadCoupons(CouponRepository repo) {
        return args -> {

            if (repo.count() == 0) {

                List<Coupons> list = new ArrayList<>();

                list.add(create(1, "SAVE20", 20.0, "2024-06-30"));
                list.add(create(2, "DEAL10", 10.0, "2024-08-31"));
                list.add(create(3, "FREESHIP", 5.0, "2024-12-31"));
                list.add(create(4, "SPRING25", 25.0, "2024-04-30"));
                list.add(create(5, "SUMMER15", 15.0, "2024-07-31"));
                list.add(create(6, "FALL20", 20.0, "2024-10-31"));
                list.add(create(7, "WINTER10", 10.0, "2024-12-31"));
                list.add(create(8, "Hkljhh", 15.0, "2024-10-31"));
                list.add(create(9, "BLACKFRIDAY", 30.0, "2024-11-30"));
                list.add(create(10, "CYBERMONDAY", 25.0, "2024-12-01"));

                list.add(create(11, "HOLIDAY25", 25.0, "2024-12-31"));
                list.add(create(12, "NEWYEAR15", 15.0, "2025-01-31"));
                list.add(create(13, "VALENTINE", 20.0, "2025-02-14"));
                list.add(create(14, "SPRINGSALE", 10.0, "2025-04-30"));
                list.add(create(15, "SUMMERFUN", 15.0, "2025-07-31"));
                list.add(create(16, "BACKTOSCHOOL", 10.0, "2025-09-30"));
                list.add(create(17, "LABORDAYY", 20.0, "2025-09-01"));
                list.add(create(18, "COLUMBUS", 25.0, "2025-10-14"));
                list.add(create(19, "THANKSGIVINGG", 30.0, "2025-11-28"));
                list.add(create(20, "CHRISTMASS", 35.0, "2025-12-25"));

                list.add(create(21, "NEWYEAR", 30.0, "2026-01-01"));
                list.add(create(22, "SUPERBOWL", 20.0, "2026-02-08"));
                list.add(create(23, "PRESIDENTS", 15.0, "2026-02-16"));
                list.add(create(24, "STPATRICK", 20.0, "2026-03-17"));
                list.add(create(25, "EASTER", 25.0, "2026-04-05"));
                list.add(create(26, "MOTHERSDAY", 15.0, "2026-05-10"));
                list.add(create(27, "MEMORIAL", 20.0, "2026-05-25"));
                list.add(create(28, "FATHERSDAY", 15.0, "2026-06-21"));
                list.add(create(29, "INDEPENDENCE", 20.0, "2026-07-04"));
                list.add(create(30, "LABORDAY", 25.0, "2026-09-07"));

                list.add(create(31, "HALLOWEEN", 30.0, "2026-10-31"));
                list.add(create(32, "THANKSGIVING", 35.0, "2026-11-26"));
                list.add(create(33, "CHRISTMAS", 40.0, "2026-12-25"));
                list.add(create(34, "NEWYEARR", 30.0, "2027-01-01"));
                list.add(create(35, "VALENTINEE", 20.0, "2027-02-14"));
                list.add(create(36, "EASTERR", 25.0, "2027-04-05"));
                list.add(create(37, "MOTHERSDAYY", 20.0, "2027-05-10"));
                list.add(create(38, "MEMORIALL", 25.0, "2027-05-25"));
                list.add(create(39, "FATHERSDAYY", 20.0, "2027-06-21"));
                list.add(create(40, "INDEPENDENCEE", 25.0, "2027-07-04"));

                list.add(create(41, "LABORDAYYY", 30.0, "2027-09-07"));
                list.add(create(42, "HALLOWEENN", 35.0, "2027-10-31"));
                list.add(create(43, "Tjkhkgjj", 40.0, "2027-11-26"));
                list.add(create(44, "Cgjgjkjhk", 45.0, "2027-12-25"));
                list.add(create(45, "Nhkhkjjl", 35.0, "2028-01-01"));
                list.add(create(46, "Vjnkjkj", 25.0, "2028-02-14"));
                list.add(create(47, "Eijgjgj", 30.0, "2028-04-05"));
                list.add(create(48, "MhkjkjkjY", 25.0, "2028-05-10"));
                list.add(create(49, "MhkkjkjkL", 30.0, "2028-05-25"));
                list.add(create(50, "FATHEhihhAY", 25.0, "2028-06-21"));

                repo.saveAll(list);

                System.out.println("✅ 50 Coupons Inserted Successfully!");
            }
        };
    }

    private Coupons create(int id, String code, double discount, String date) {
        Coupons c = new Coupons();
        c.setCouponId(id);
        c.setCouponCode(code);
        c.setDiscount(discount);
        c.setExpiryDate(LocalDate.parse(date));
        return c;
    }
} 