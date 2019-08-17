package com.akgbs.tests;

import com.akgbs.domain.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Given a status")
class NodeTest {

    @Test
    @DisplayName("when created check attributes getters")
    public void creation_test(){
        String name = "Stato1";
        String description  = "first stage of this graph";

        Node x = new Node(name, description);
        assertEquals(name, x.getName());
        assertEquals(description, x.getDescription());
    }

}