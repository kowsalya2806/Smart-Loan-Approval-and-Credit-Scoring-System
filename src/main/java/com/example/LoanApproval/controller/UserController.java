package com.example.LoanApproval.controller;

import com.example.LoanApproval.entity.User;
import com.example.LoanApproval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class UserController {
 
    @Autowired
    private UserService userService;

    //show register form
    @GetMapping("/register")
    public String showRegisterFrom(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    //handle
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        userService.register(user);
        return "redirect:/login";
       }

    // show login
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    
    //admin view
    @GetMapping("/admin/users")
    public String ListUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    
}
