package com.Task8.BH_Intern.controller;


import com.Task8.BH_Intern.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "*") // allow frontend requests
@RequestMapping("/tasks")
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    // GET - return all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    // POST - add new task
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setId(counter.getAndIncrement());
        tasks.add(task);
        return task;
    }
}
