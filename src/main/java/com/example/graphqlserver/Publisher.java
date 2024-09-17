package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

public record Publisher(String id, String companyName, String companyAddress) {

    private final static List<Publisher> publishers = Arrays.asList(
            new Publisher("publisher-1", "publisher company name 1", "publisher company address 1"),
            new Publisher("publisher-2", "publisher company name 2", "publisher company address 2"),
            new Publisher("publisher-3", "publisher company name 3", "publisher company address 3"),
            new Publisher("publisher-4", "publisher company name 4", "publisher company address 4")
    );

    public static Publisher getById(String id) {
        return publishers.stream()
				.filter(publisher -> publisher.id().equals(id))
				.findFirst()
				.orElse(null);
    }

    public static Publisher getByCompanyName(String companyName) {
        return publishers.stream()
                .filter(publisher -> publisher.companyName().equals(companyName))
                .findFirst()
                .orElse(null);
    }

    public static Publisher getByCompanyAddress(String companyAddress) {
        return publishers.stream()
                .filter(publisher -> publisher.companyAddress().equals(companyAddress))
                .findFirst()
                .orElse(null);
    }
}
