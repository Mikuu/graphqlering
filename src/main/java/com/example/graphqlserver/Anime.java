package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

public record Anime(String id, String title, String releasedDate, String publisherId, String scale, List<String> stars) {

    private final static List<Anime> ANIME = Arrays.asList(
            new Anime("anime-1", "Title 1", "released date 1", "publisher-1", "good", List.of("actor-1", "actor-2")),
            new Anime("anime-2", "Title 2", "released date 2", "publisher-2", "good", List.of("actor-3", "actor-4", "actor-5")),
            new Anime("anime-3", "Title 3", "released date 3", "publisher-3", "just so so", List.of("actor-1", "actor-3", "actor-5"))
    );

    public static Anime getById(String id) {
        return ANIME.stream()
                .filter(anime -> anime.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Anime getByTitle(String title) {
        return ANIME.stream()
                .filter(anime -> anime.title().equals(title))
                .findFirst()
                .orElse(null);
    }

    public static Anime getByReleasedDate(String releasedDate) {
        return ANIME.stream()
                .filter(anime -> anime.releasedDate().equals(releasedDate))
                .findFirst()
                .orElse(null);
    }

    public static Anime getByPublisherId(String publisherId) {
        return ANIME.stream()
                .filter(anime -> anime.publisherId().equals(publisherId))
                .findFirst()
                .orElse(null);
    }
}
