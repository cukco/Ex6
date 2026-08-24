package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String search) {
        List<Task> tasks = taskService.findAllTasks();
        
        if (search != null && !search.trim().isEmpty()) {
            tasks = tasks.stream()
                    .filter(task -> task.getTitle().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }
        
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if(taskService.findUserById(task.getAssignedTo())==null){
            return ResponseEntity.badRequest().build();
        }
        List<Task> tasks = taskService.findAllTasks();
        tasks.add(task);
        return  ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id,@RequestBody Task task) {
        if(taskService.saveTask(task.getId(),task)==null){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(task);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        if(taskService.deleteTask(id)==null){
            return ResponseEntity.notFound().build();
        }else  {
            return ResponseEntity.ok(task);
        }
    }
}
