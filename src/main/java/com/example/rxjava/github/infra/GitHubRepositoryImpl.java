package com.example.rxjava.github.infra;

import com.example.rxjava.github.domain.GitHubCommits;
import com.example.rxjava.github.domain.GitHubRepository;
import com.example.rxjava.github.domain.GitHubUserProfile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RequiredArgsConstructor
@Repository
public class GitHubRepositoryImpl implements GitHubRepository {
    private final WebClient webClient;

    public Flux<GitHubCommits> selectGitHubCommitList(){
        AtomicReference<String> aStrPreDt = new AtomicReference<>();

        String strCurrentDt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        return Flux.interval(Duration.ofSeconds(5)).flatMap(i->{
            Flux<GitHubCommits> result = null;
            if(i == 0) {
                aStrPreDt.set(strCurrentDt);
                result = webClient
                        .get()
                        .uri("/repos/ppyong/ppyong.github.io/commits?until={until}", strCurrentDt)
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToFlux(GitHubCommits.class)
                        .log();
            }else{
                result = webClient
                        .get()
                        .uri("/repos/ppyong/ppyong.github.io/commits?since={since}", aStrPreDt.get())
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToFlux(GitHubCommits.class)
                        .log();
                aStrPreDt.set(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            }
            result.onErrorReturn(new GitHubCommits());
            return result;
        });
    }

    public Mono<GitHubUserProfile> selectUserProfile(String username){
        return webClient.get().uri("/users/{username}", username)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GitHubUserProfile.class)
                .log();
    }
}
