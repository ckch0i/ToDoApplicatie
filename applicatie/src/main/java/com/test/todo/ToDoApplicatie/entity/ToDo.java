package com.test.todo.ToDoApplicatie.entity;


import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    Instant aangemaaktOp;
    Instant verlooptOp;
    String status;
    String omschrijving;
    String uniekeId;
}
