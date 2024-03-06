package com.sneakersco.admin.user.controller;

import com.sneakersco.admin.user.service.UserService;
import com.sneakersco.admin.user.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listAll(){
        return "users";
    }
}
