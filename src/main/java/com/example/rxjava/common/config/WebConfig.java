package com.example.rxjava.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebConfig {
    private final WebClient.Builder builder;

    @Bean
    public WebClient webClient(){
        return builder
                .baseUrl("https://api.github.com")
                .defaultHeader("Authorization", "")
                .build();
    }
}
