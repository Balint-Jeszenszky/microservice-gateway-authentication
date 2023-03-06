package com.example.gateway.demo;

import com.example.gateway.demo.security.jwt.JwtUtils;
import com.example.gateway.demo.security.model.User;
import com.example.gateway.demo.security.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayDemoApplication {

	@Autowired
	private JwtUtils jwtUtils;

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/api/spring")
						.filters(f -> f.rewritePath("/api/spring", "/api/user"))
						.uri("http://localhost:8081"))
				.route(p -> p
						.path("/api/nest")
						.filters(f -> f.rewritePath("/api/nest", "/auth/user"))
						.uri("http://localhost:3000"))
				.route(p -> p
						.path("/api/login")
						.filters(f -> f.modifyResponseBody(
								User.class,
								UserData.class,
								(exchange, s) -> Mono.just(
										new UserData(
												new User(s.getId(), s.getUsername(), s.getRoles()),
												jwtUtils.generateJwtToken(s),
												jwtUtils.generateJwtRefreshToken(s)))))
						.uri("http://localhost:3001"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayDemoApplication.class, args);
	}

}
