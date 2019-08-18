package com.akgbs.domain;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;

public class Task {
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

    public Process getProcess() {
        return process;
    }

    private Process process;

    public Task() {

    }

    public Task(Task parentTask, ArrayList<Task> childrenTasks, Process process) {
        this.parentTask = parentTask;
        setChildrenTasks(childrenTasks);
        this.process = process;
    }


    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public ArrayList<Task> getChildrenTasks() {
        return childrenTasks;
    }

    public void setChildrenTasks(ArrayList<Task> childrenTasks) {
        checkValidity(childrenTasks, parentTask);
        this.childrenTasks = childrenTasks;
    }

    private static void checkValidity(ArrayList<Task> childrenTasks, Task parentTask) {
        Task parent = parentTask;
        while(null != parent){
            if(childrenTasks.contains(parent)) {
                throw new IllegalArgumentException("Recursion active");
            }
            parent = parent.parentTask;
        }
    }
}
