package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        tasks.add(new Task(1L, "Setup project", "Initial Spring Boot setup", "HIGH", 1L));
        tasks.add(new Task(2L, "Create models", "Create User and Task entities", "HIGH", 1L));
        tasks.add(new Task(3L, "Create repositories", "Create User and Task repositories", "MEDIUM", 2L));
        tasks.add(new Task(4L, "Create services", "Create User and Task services", "MEDIUM", 3L));
        tasks.add(new Task(5L, "Create controllers", "Create User and Task controllers", "MEDIUM", 2L));
        tasks.add(new Task(6L, "Test API", "Test the endpoints using Postman", "LOW", 3L));
        tasks.add(new Task(7L, "Add validation", "Add input validation", "LOW", 1L));
        tasks.add(new Task(8L, "Write unit tests", "Write JUnit tests for services", "MEDIUM", 2L));
        tasks.add(new Task(9L, "Deploy to dev", "Deploy application to dev server", "HIGH", 1L));
        tasks.add(new Task(10L, "Documentation", "Write API documentation", "LOW", 3L));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public Task save(long id, Task task) {
        Task updatedTask = findById(id);
        if(updatedTask != null) {
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setPriority(task.getPriority());
            updatedTask.setAssignedTo(task.getAssignedTo());
        }
        return updatedTask;
    }

    public Task delete(long id) {
        Task task = findById(id);
        if(task != null) {
            tasks.remove(task);
        }
        return task;
    }
}
