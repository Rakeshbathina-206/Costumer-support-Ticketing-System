package com.BH_Intern.Task7.controller;

import com.BH_Intern.Task7.model.Task;
import com.BH_Intern.Task7.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // Constructor injection (best practice)
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ✅ 1. Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    // ✅ 2. Get task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ 3. Create new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    // ✅ 4. Update task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Optional<Task> updated = taskService.update(id, updatedTask);
        return updated.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ 5. Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean deleted = taskService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
