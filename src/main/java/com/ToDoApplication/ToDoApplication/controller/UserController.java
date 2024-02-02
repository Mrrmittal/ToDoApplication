package com.ToDoApplication.ToDoApplication.controller;

import com.ToDoApplication.ToDoApplication.model.User;
import com.ToDoApplication.ToDoApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/login" , "/"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login/login";
    }

    @PostMapping("/home")
    public String showAccountLogin(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/todo";
    }


    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user",new User());
        return "SignUp/register_form";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/signup?success";
    }

}
