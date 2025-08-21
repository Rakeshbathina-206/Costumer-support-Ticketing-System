package com.BH_Intern.Task7.service;


import com.BH_Intern.Task7.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final ConcurrentHashMap<Long, Task> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(0);

    // Return all tasks
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    // Find by id -> return Optional<Task>
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // Create new task (generates id) -> return Task
    public Task create(Task task) {
        long id = idGen.incrementAndGet();
        task.setId(id);
        store.put(id, task);
        return task;
    }

    // Update existing task; returns Optional.empty() if not present
    public Optional<Task> update(Long id, Task updated) {
        return Optional.ofNullable(store.computeIfPresent(id, (k, existing) -> {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            return existing;
        }));
    }

    // Delete
    public boolean delete(Long id) {
        return store.remove(id) != null;
    }

    // Optional: clear all (useful for tests)
    public void clearAll() {
        store.clear();
        idGen.set(0);
    }
}
