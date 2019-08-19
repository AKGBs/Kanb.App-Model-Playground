package com.akgbs.domain;

import lombok.Data;

public @Data
class Arc {
    private final Node from;
    private final Node to;

    public Arc(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

}
