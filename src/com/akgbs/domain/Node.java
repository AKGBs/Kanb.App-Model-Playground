package com.akgbs.domain;

public class Node {
    private final String name;
    private final String description;

    public Node(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }
}
