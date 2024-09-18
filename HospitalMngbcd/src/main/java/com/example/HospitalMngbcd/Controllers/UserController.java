package com.example.HospitalMngbcd.Controllers;

import com.example.HospitalMngbcd.Models.User;
import com.example.HospitalMngbcd.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Frontend URL
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getALLUsers();
    }

    @PostMapping("/users")
    public String registerUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public User gstUserDetails(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
