package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    // Add Task
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // Get All Tasks
    @GetMapping
    public List<Task> getTasks() {
        return repository.findAll();
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        repository.deleteById(id);

        return "Task Deleted";
    }
}