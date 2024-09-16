package com.example.lbgateway;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return 
		builder.routes().route(
				"lbgateway",
				r->r.path("/test/**")
//				.uri("http://localhost:62972")
				.uri("lb://LBSERVICE")
				).build();
}
}