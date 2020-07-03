package com.cloud.gateway.config;

import com.cloud.gateway.filter.GeteWayFilter;
import com.cloud.gateway.filter.GeteWayFilter2;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayRoutesConfiguration {

    //java配置路由

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        System.out.println("gateway filter code...");
        return builder.routes()
                .route(r ->
                        r.path("/product/**")
                                .filters(
                                        f -> f.stripPrefix(0)  //0的话不会去掉前缀 http://localhost:9701/product/1?token=xxx ->http://localhost:9701/product/1?token=xxx
                                                .filters(new GeteWayFilter(),new GeteWayFilter2())
                                )
                                .uri("http://127.0.0.1:9101")  //lb://product-service
                )
                .build();
    }
}
