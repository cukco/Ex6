package com.example.taskmanagement.services;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public User findUserById(long id) {
        return userService.findById(id);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(long id,Task task) {
        return taskRepository.save(id,task);
    }

    public Task deleteTask(long id) {
        return taskRepository.delete(id);
    }
}
