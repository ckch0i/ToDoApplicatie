package com.test.todo.ToDoApplicatie.controller;

import com.test.todo.ToDoApplicatie.model.RegisterUserDTO;
import com.test.todo.ToDoApplicatie.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        userService.createUser(registerUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
