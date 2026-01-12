package com.web.controller;

import com.web.model.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", userService.getUserById(id));
        return "users";
    }
}

