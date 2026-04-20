package com.sprint.food_delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // USERS
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails hemanth = User.withUsername("hemanth")
                .password(passwordEncoder().encode("pass1"))
                .roles("HEMANTH")
                .build();

        UserDetails kisol = User.withUsername("kisol")
                .password(passwordEncoder().encode("pass2"))
                .roles("KISOL")
                .build();

        UserDetails thenmozhi = User.withUsername("thenmozhi")
                .password(passwordEncoder().encode("pass3"))
                .roles("THENMOZHI")
                .build();

        UserDetails annie = User.withUsername("annie")
                .password(passwordEncoder().encode("pass4"))
                .roles("ANNIE")
                .build();

        UserDetails jeevitha = User.withUsername("jeevitha")
                .password(passwordEncoder().encode("pass5"))
                .roles("JEEVITHA")
                .build();

        return new InMemoryUserDetailsManager(
                admin, hemanth, kisol, thenmozhi, annie, jeevitha
        );
    }

    // SECURITY CONFIG
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // 🔥 IMPORTANT FIX: NO SESSION STORAGE
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // EXCEPTION HANDLING
            .exceptionHandling(ex -> ex

                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(401);
                    response.setContentType("application/json");
                    response.getWriter().write(
                        "{\"error\": \"Unauthorized - Please login first\"}"
                    );
                })

                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setStatus(403);
                    response.setContentType("application/json");
                    response.getWriter().write(
                        "{\"error\": \"Access Denied - You are not allowed to access this resource\"}"
                    );
                })
            )

            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/admin/**").hasRole("ADMIN")

                .requestMatchers("/customers/**", "/addresses/**",
                                 "/restaurants/**", "/menu-items/**")
                    .hasRole("HEMANTH")

                .requestMatchers("/orders/**", "/order-items/**",
                                 "/drivers/**", "/delivery/**")
                    .hasRole("KISOL")

                .requestMatchers("/customers/**", "/addresses/**",
                                 "/orders/**", "/order-items/**")
                    .hasRole("THENMOZHI")

                .requestMatchers("/restaurants/**", "/menu-items/**",
                                 "/ratings/**")
                    .hasRole("ANNIE")

                .requestMatchers("/coupons/**", "/drivers/**", "/delivery/**")
                    .hasRole("JEEVITHA")

                .anyRequest().authenticated()
            )

            .formLogin(form -> form.permitAll());

        return http.build();
    }
}