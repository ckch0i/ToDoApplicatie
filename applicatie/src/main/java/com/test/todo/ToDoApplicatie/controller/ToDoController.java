package com.test.todo.ToDoApplicatie.controller;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.service.ToDoService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/todo")
@RestController
public class ToDoController {

    @Resource
    ToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDoDTO> maakToDo(@RequestBody ToDoDTO toDoDTO) {
        ToDoDTO result = toDoService.maakDTO(toDoDTO);
        if (result.getUniekeId() != null){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<ToDoDTO> getToDo(@RequestParam String uniekeId) {
        ToDoDTO result = toDoService.zoekToDo(uniekeId);
        if (result != null){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
