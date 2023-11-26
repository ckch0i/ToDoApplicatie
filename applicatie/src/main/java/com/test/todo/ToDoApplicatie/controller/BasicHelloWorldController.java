package com.test.todo.ToDoApplicatie.controller;

import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.service.ToDoService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class BasicHelloWorldController {

    @GetMapping
    public ResponseEntity<String> getTest(){
        ResponseEntity response = new ResponseEntity<>("hello-world", HttpStatusCode.valueOf(200));
        return response;
    }

}
