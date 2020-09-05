package com.example.rxjava.github.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GitHubCommits {

    private String url;

    private String sha;

    private String nodeId;

    private String htmlUrl;

    private String commentsUrl;

    private Commit commit;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Commit {

        private String url;

        private Author author;

        private Committer committer;

        private String message;

        private long commentCount;

        private Verification verification;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Author {

            private String name;

            private String email;

            private LocalDateTime date;
        }

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Committer {

            private String name;

            private String email;

            private LocalDateTime date;
        }

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Tree {

            private String url;

            private String sha;
        }

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Verification {

            private boolean verified;

            private String reason;

            private String signature;

            private String payload;
        }
    }
}
