package com.test.todo.ToDoApplicatie.service;

import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ToDoService {

    public ToDoDTO maakDTO(String omschrijving){
        ToDoDTO toDoDTO = new ToDoDTO(omschrijving, Instant.now());
        return toDoDTO;
    }
}
