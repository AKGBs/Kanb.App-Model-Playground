package com.akgbs.tests;


import com.akgbs.domain.Arc;
import com.akgbs.domain.GraphProcess;
import com.akgbs.domain.Node;
import com.akgbs.domain.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Given nodes, arcs, sample process")
public class SampleGraphProcessTest {

    private static GraphProcess graphProcess;

    private static final Node backlog = new Node("Backlog", "First stage");
    private static final Node todo = new Node("Todo", "Todo stage");
    private static final Node doing = new Node("Doing", "Doing stage");
    private static final Node done = new Node("Done", "Done stage");
    private static final Node finished = new Node("Finished", "Finish stage");

    private static final Arc firstArc = new Arc(backlog, todo);
    private static final Arc secondArc = new Arc(todo, doing);
    private static final Arc thirdArc = new Arc(doing, done);
    private static final Arc fourthArc = new Arc(done, finished);
    private static final ArrayList<Arc> arcArr = Stream
        .of(firstArc, secondArc, thirdArc, fourthArc)
        .collect(Collectors.toCollection(ArrayList::new));

    @BeforeAll
    public static void settings() {
        graphProcess = new GraphProcess(arcArr);
    }

    @Test
    @DisplayName("when created, bring a task from the start node to the end")
    public void test_moving_task() {
        Task task = new Task(graphProcess);
        assertEquals(backlog, task.getCurrentNode());

        assertEquals(todo, task.next());
        assertEquals(todo, task.getCurrentNode());

        assertEquals(doing, task.next());
        assertEquals(doing, task.getCurrentNode());

        assertEquals(done, task.next());
        assertEquals(done, task.getCurrentNode());

        assertEquals(finished, task.next());
        assertEquals(finished, task.getCurrentNode());

        assertThrows(NoSuchElementException.class, () -> task.next());
    }

}
