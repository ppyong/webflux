package com.example.rxjava.github.ui;

import com.example.rxjava.github.domain.GitHubCommits;
import com.example.rxjava.github.domain.GitHubService;
import com.example.rxjava.github.domain.GitHubUserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GitHubHandler {
    private final GitHubService gitHubService;

    public Mono<ServerResponse> getCommits(ServerRequest serverRequest){
        return ServerResponse.ok().body(gitHubService.getCommits(), GitHubCommits.class);
    }

    public Mono<ServerResponse> getUserProfile(ServerRequest serverRequest){
        return ServerResponse.ok().body(gitHubService.getUserProfile(serverRequest.pathVariable("username")), GitHubUserProfile.class);
    }
}
