package com.akgbs.tests;

import com.akgbs.domain.Arc;
import com.akgbs.domain.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Given from and to nodes")
class ArcTest {

    private static Node from;
    private static Node to;

    @BeforeAll
    public static void settings() {
        from = new Node("Status1", "Description 1");
        to = new Node("Status2", "Description 2");
    }

    @Test
    @DisplayName("when created an arc check attribute getters")
    public void testing_property() {
        Arc arc = new Arc(from, to);

        assertEquals(from, arc.getFrom());
        assertEquals(to, arc.getTo());
    }
}