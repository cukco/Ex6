package com.example.taskmanagement.services;

import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(long id) {
        return userRepository.findOne(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.add(user);
    }

    public User updateUser(Long id,User user) {
        return userRepository.update(id,user);
    }

    public User deleteUser(Long id) {
        return userRepository.delete(id);
    }
}
