package net.mierzvoj.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .uri("http://localhost:9191"))
                .route(p -> p.path("/api/departments/**")
                        .uri("lb://department-service"))
                .route(p -> p.path("/api/employees/**")
                        .uri("lb://employee-service"))
                .build();
    }
}
