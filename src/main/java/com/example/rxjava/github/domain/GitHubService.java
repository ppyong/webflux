package com.example.rxjava.github.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class GitHubService {
    private final GitHubRepository gitHubRepository;

    public Flux<GitHubCommits> getCommits() {
        return gitHubRepository.selectGitHubCommitList();
    }

    public Mono<GitHubUserProfile> getUserProfile(String username) {
        return gitHubRepository.selectUserProfile(username);
    }
}
