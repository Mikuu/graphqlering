package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

public record Actor(String id, String name, int age, String gender, String scale) {

    private static final List<Actor> actors = Arrays.asList(
            new Actor("actor-1", "actor name 1", 12, "male", "SS"),
            new Actor("actor-2", "actor name 2", 14, "female", "A"),
            new Actor("actor-3", "actor name 3", 14, "female", "AA"),
            new Actor("actor-4", "actor name 4", 24, "female", "SSS"),
            new Actor("actor-5", "actor name 5", 18, "male", "A+")
    );

    public static Actor getById(String id) {
        return actors.stream()
				.filter(actor -> actor.id().equals(id))
				.findFirst()
				.orElse(null);
    }

    public static Actor getByName(String name) {
        return actors.stream()
                .filter(actor -> actor.name().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static Actor getByAge(int age) {
        return actors.stream()
                .filter(actor -> actor.age() == age)
                .findFirst()
                .orElse(null);
    }

    public static Actor getByGender(String gender) {
        return actors.stream()
                .filter(actor -> actor.gender().equals(gender))
                .findFirst()
                .orElse(null);
    }

    public static Actor getByScale(String scale) {
        return actors.stream()
                .filter(actor -> actor.scale().equals(scale))
                .findFirst()
                .orElse(null);
    }
}
