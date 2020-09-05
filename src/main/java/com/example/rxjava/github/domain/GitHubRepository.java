package com.example.rxjava.github.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GitHubRepository {
    Flux<GitHubCommits> selectGitHubCommitList();

    Mono<GitHubUserProfile> selectUserProfile(String username);
}
