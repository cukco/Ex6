package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1L, "admin", "admin@example.com", "ADMIN"));
        users.add(new User(2L, "user1", "user1@example.com", "USER"));
        users.add(new User(3L, "user2", "user2@example.com", "USER"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User add(User user) {
        users.add(user);
        return user;
    }

    public User update(long id,User user) {
        User oldUser = findOne(id);
        if(oldUser==null){
            return null;
        }else{
            oldUser.setEmail(user.getEmail());
            oldUser.setRole(user.getRole());
            oldUser.setUsername(user.getUsername());
            return oldUser;
        }
    }

    public User delete(long id) {
        User oldUser = findOne(id);
        users.remove(oldUser);
        return oldUser;
    }
}
