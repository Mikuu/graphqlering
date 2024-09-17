package com.example.graphqlserver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimeController {
    @QueryMapping
    public Anime animeById(@Argument String id) {
        return Anime.getById(id);
    }

    @SchemaMapping
    public Publisher publisher(Anime anime) {
        return Publisher.getById(anime.publisherId());
    }

    @SchemaMapping
    public List<Actor> stars(Anime anime) {
        List<Actor> stars = new ArrayList<>();
        anime.stars().forEach(authorId -> stars.add(Actor.getById(authorId)));

        return stars;
    }
}