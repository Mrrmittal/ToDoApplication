package com.ToDoApplication.ToDoApplication.service.impl;

import com.ToDoApplication.ToDoApplication.model.User;
import com.ToDoApplication.ToDoApplication.repository.UserRepository;
import com.ToDoApplication.ToDoApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long Id) {
         userRepository.deleteById(Id);
    }

    @Override
    public List<User> getAllUser(User user) {
        return userRepository.findAll();
    }

//    @Override
//    public boolean isValidUser(String email){
//        User user = userRepository.findByEmail(email);
//
//    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
