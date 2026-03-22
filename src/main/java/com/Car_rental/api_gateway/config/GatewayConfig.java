package com.Car_rental.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("car-rental-vehicle-service-api",p -> p.path("/api/v1/vehicles/**")
                        .uri("lb://car-rental"))
                .route("car-rental-booking-service-api",p -> p.path("/api/bookings/**")
                        .uri("lb://booking-service"))
                .route("car-rental-customer-service-api",p -> p.path("/customers/**")
                        .uri("lb://customer-service"))
                .route("car-rental-payment-service-api",p -> p.path("/payments/**")
                        .uri("lb://paymentService"))
                .build();
    }
}
