package com.ym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


/*    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(route -> route.path("/customers/**").uri("http://localhost:8081"))
                .route(route -> route.path("/accounts/**").uri("http://localhost:8082"))
                .build();
    }*/

    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamic(
            ReactiveDiscoveryClient rdc,
            DiscoveryLocatorProperties dlp
    ){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp );
    }
}
