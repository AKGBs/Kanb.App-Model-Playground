package com.akgbs.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

public @Data class Task {
    /*
     * A task is a pointer that moves from one node
     * to another one and it's part of the execution flow.
     *
     * Each task can be connected with one or more tasks.
     * Each parent task can have one or more child tasks
     */

    private Node currentNode;
    private Task parentTask;
    private ArrayList<Task> childrenTasks;
    private GraphProcess graphProcess;
    private final UUID id = UUID.randomUUID();

    public Task() {
    }

    public Task(GraphProcess graphProcess) {
        setGraphProcess(graphProcess);
    }

    public Task(Task parentTask, ArrayList<Task> childrenTasks, GraphProcess graphProcess) {
        this.parentTask = parentTask;
        setGraphProcess(graphProcess);
        setChildrenTasks(childrenTasks);
    }

    public void setGraphProcess(GraphProcess graphProcess) {
        this.graphProcess = graphProcess;
        this.currentNode = graphProcess.getArcList().get(0).getFrom();
    }

    public void setChildrenTasks(ArrayList<Task> childrenTasks) {
        checkValidity(childrenTasks, parentTask);
        this.childrenTasks = childrenTasks;
    }

    private static void checkValidity(ArrayList<Task> childrenTasks, Task parentTask) {
        Task parent = parentTask;
        while (null != parent) {
            if (childrenTasks.contains(parent)) {
                throw new IllegalArgumentException("Recursion active");
            }
            parent = parent.parentTask;
        }
    }

    public Node next() {
        Node node = graphProcess.getNext(this.currentNode);
        this.setCurrentNode(node);
        return getCurrentNode();
    }
}
