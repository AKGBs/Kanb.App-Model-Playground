package com.akgbs.tests;

import com.akgbs.domain.Arc;
import com.akgbs.domain.Node;
import com.akgbs.domain.Process;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given a process")
class ProcessTest {

    private static ArrayList<Arc> arcs;

    @BeforeAll
    public static void settings() {
        Node node1 = new Node("Node1", "This is node1");
        Node node2 = new Node("Node2", "This is node2");
        Node node3 = new Node("Node3", "This is node3");

        Arc arc12 = new Arc(node1, node2);
        Arc arc23 = new Arc(node2, node3);

        arcs = new ArrayList<>();
        arcs.add(arc12);
        arcs.add(arc23);
    }

    @Test
    @DisplayName("when created, test getters")
    void test_getters() {
        Process p = new Process(arcs);

        assertEquals(arcs, p.getArcList());
    }
}