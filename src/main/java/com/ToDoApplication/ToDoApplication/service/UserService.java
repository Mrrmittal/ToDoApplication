package com.ToDoApplication.ToDoApplication.service;

import com.ToDoApplication.ToDoApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    User saveUser(User user);
    void deleteUser(Long Id);
    List<User> getAllUser(User user);
    public User findByEmail(String email);
}
