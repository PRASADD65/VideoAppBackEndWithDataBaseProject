package com.example.student.demo.student.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.student.demo.student.module.User;
import com.example.student.demo.student.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User exstingUser = userRepository.findByFirstName(user.getFirstName());
        if (exstingUser != null && user.getPassword().equals(exstingUser.getPassword())) {
            return "successful";
        }
        else if (exstingUser == null)
        {
            return "User Not Found !";
        }
        else {
            return "Login Failed !";
        }
    }
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        User exstingUser = userRepository.findByFirstName(user.getFirstName());
        if(user.getFirstName().isBlank()|| user.getLastName().isBlank()||user.getPassword().isBlank())
        {
            return "Failed: fill the all the fields !";
        }
        else if(exstingUser != null)
        {
            return "Username Already Exists !";
        }
        else {
            userRepository.save(user);
            return "Signup Successful !";
        }
    }
}