package com.akgbs.domain;

import lombok.Data;

public @Data
class Node {
    private final String name;
    private final String description;

    public Node(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
