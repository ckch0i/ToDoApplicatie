package com.test.todo.ToDoApplicatie.controller;

import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.service.ToDoService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/todo")
@RestController
public class ToDoController {

    @Resource
    ToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDoDTO> maakToDo(@RequestBody ToDoDTO toDoDTO, Authentication authentication) {
        ToDoDTO result = toDoService.maakDTO(toDoDTO, authentication);
        if (result.getUniekeId() != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<ToDoDTO> getToDo(@RequestParam String uniekeId, Authentication authentication) {
        ToDoDTO result = toDoService.zoekToDo(uniekeId, authentication);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDoDTO>> getAllToDo(Authentication authentication) {
        List<ToDoDTO> result = toDoService.haalAlleToDo(authentication);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
