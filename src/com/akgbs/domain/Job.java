package com.akgbs.domain;

import lombok.Data;

import java.util.ArrayList;

public @Data
class Job {
    /*
     * Group of tasks that are logically grouped to execute a job
     */

    private final String name;
    private final String description;
    private final ArrayList<Task> taskArray;

    public Job(String name, String description, ArrayList<Task> taskArray) {
        this.taskArray = taskArray;
        this.name = name;
        this.description = description;
    }


}
