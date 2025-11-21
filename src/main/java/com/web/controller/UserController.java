package com.web.controller;

import com.web.model.User;
import com.web.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getAllUsers()                 { return service.getAllUsers(); }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id)  { return service.getUserById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User u) { return service.saveOrUpdate(u); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u) {
        u.setId(id);
        return service.saveOrUpdate(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public String getAllUsers(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }
//
//    @PostMapping("/add")
//    public String addUser(@ModelAttribute User user) {
//        userService.saveOrUpdate(user);
//        return "redirect:/users";
//    }
//
//    @PostMapping("/update")
//    public String updateUser(@ModelAttribute User user) {
//        userService.saveOrUpdate(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editUserForm(@PathVariable Long id, Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        model.addAttribute("user", userService.getUserById(id));
//        return "users";
//    }
//}

