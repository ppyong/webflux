package com.example.rxjava.github.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitHubUserProfile {

    private String updatedAt;

    private String createdAt;

    private int following;

    private int followers;

    private int publicGists;

    private int publicRepos;

    private String twitterUsername;

    private String bio;

    private boolean hireable;

    private String email;

    private String location;

    private String blog;

    private String company;

    private String name;

    private boolean siteAdmin;

    private String type;

    private String receivedEventsUrl;

    private String eventsUrl;

    private String reposUrl;

    private String organizationsUrl;

    private String subscriptionsUrl;

    private String starredUrl;

    private String gistsUrl;

    private String followingUrl;

    private String followersUrl;

    private String htmlUrl;

    private String url;

    private String gravatarId;

    private String avatarUrl;

    private String nodeId;

    private int id;

    private String login;
}
