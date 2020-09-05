package com.example.rxjava.github.ui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@EnableWebFlux
@Configuration
public class GitHubRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(GitHubHandler gitHubHandler){
        return nest(path("/api/v1"),
                route(GET("/commits").and(accept(MediaType.APPLICATION_STREAM_JSON)), gitHubHandler::getCommits)
                .andRoute(GET("/users/{username}").and(accept(MediaType.APPLICATION_JSON)), gitHubHandler::getUserProfile));
    }
}
