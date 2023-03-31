package com.qirara.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    // configure route locator
    @Bean
    public RouteLocator gatewayRounter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(
                                f -> f.addRequestHeader("Author", "Mahiru-x-Hikaru")
                                        .addRequestParameter("Waifu", "Shina-Mahiru"))
                        .uri("http://httpbin.org"))

                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange")) // lb -> load balancer , ://currency-exchange -> service name
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))

                // rewrite path
                // rewrite from old path to new path example currency-conversion-new/** -> will get currency-conversion-feign/**
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(
                                f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                        "/currency-conversion-feign/${segment}")
                        ).uri("lb://currency-conversion"))
                .build();
    }
}
