package com.akgbs.tests;

import com.akgbs.domain.Arc;
import com.akgbs.domain.Node;
import com.akgbs.domain.GraphProcess;
import com.akgbs.domain.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.IllegalArgumentException;

@DisplayName("Given task")
class TaskTest {

    private static Task parentTask;
    private static Task childTask;
    private static ArrayList<Task> children;
    private static GraphProcess graphProcess;

    @BeforeAll
    public static void settings() {
        parentTask = new Task();
        childTask = new Task();

        children = new ArrayList<>();
        children.add(childTask);

        Arc arc1 = new Arc(
            new Node("Node1", "Description 1"),
            new Node("Node2", "Description 2")
        );
        ArrayList<Arc> arcList = new ArrayList<>();
        arcList.add(arc1);
        graphProcess = new GraphProcess(arcList);
    }

    @Test
    @DisplayName("When created, check attributes getter and setter")
    void test_attributes_getter_and_setter() {
        Node aNode = new Node("Name", "Description");
        Task task = new Task();

        task.setCurrentNode(aNode);
        assertEquals(aNode, task.getCurrentNode());

        task.setParentTask(parentTask);
        assertEquals(parentTask, task.getParentTask());

        task.setChildrenTasks(children);
        assertEquals(children, task.getChildrenTasks());
    }

    @Test
    @DisplayName("When added a parent as child task, throw an exception")
    void test_parent_cant_be_child() {
        Task task = new Task();
        task.setParentTask(parentTask);
        ArrayList<Task> modifiedChildren = new ArrayList<>(children);
        modifiedChildren.add(parentTask);

        assertThrows(IllegalArgumentException.class, () -> {
            task.setChildrenTasks(modifiedChildren);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Task anotherTask = new Task(parentTask, modifiedChildren, graphProcess);
        });
    }

    @Test
    @DisplayName("When created with GraphProcess, set first node")
    void test_graph_process() {
        Task task = new Task(graphProcess);
        assertEquals("Node1", task.getCurrentNode().getName());
    }
}