package com.akgbs.tests;

import com.akgbs.domain.Node;
import com.akgbs.domain.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.IllegalArgumentException;

@DisplayName("Given task")
class TaskTest {

    @Test
    @DisplayName("When created, check attributes getter and setter")
    void test_attributes_getter_and_setter() {
        Task task = new Task();
        Task parentTask = new Task();
        Task childTask = new Task();
        ArrayList<Task> children = new ArrayList<>();
        Node aNode = new Node("Name", "Description");

        task.setCurrentNode(aNode);
        assertEquals(aNode, task.getCurrentNode());

        task.setParentTask(parentTask);
        assertEquals(parentTask, task.getParentTask());

        children.add(childTask);
        task.setChildrenTasks(children);
        assertEquals(children, task.getChildrenTasks());
    }

    @Test
    @DisplayName("When added a parent as child task, throw an exception")
    void test_parent_cant_be_child() {
        Task task = new Task();
        Task parentTask = new Task();
        ArrayList<Task> children = new ArrayList<>();

        task.setParentTask(parentTask);
        children.add(parentTask);
        assertThrows(IllegalArgumentException.class, () -> {
            task.setChildrenTasks(children);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Task anotherTask = new Task(parentTask, children);
        });

    }

}