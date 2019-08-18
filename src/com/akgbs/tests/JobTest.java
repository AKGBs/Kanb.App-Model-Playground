package com.akgbs.tests;

import com.akgbs.domain.Job;
import com.akgbs.domain.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given a job")
class JobTest {

    private static ArrayList<Task> taskArray;
    private static String name;
    private static String description;

    @BeforeAll
    public static void settings() {
        name = "Name";
        description = "Description";
        taskArray = new ArrayList<Task>(Stream
                .of(new Task(), new Task())
                .collect(Collectors.toUnmodifiableList()));
    }

    @Test
    @DisplayName("When created, check attribute getters ")
    void test_getters() {
        Job job = new Job(name, description, taskArray);

        assertEquals(name, job.getName());
        assertEquals(description, job.getDescription());
        assertEquals(taskArray, job.getTaskArray());
    }

}