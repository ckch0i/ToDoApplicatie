package com.test.todo.ToDoApplicatie.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    Instant aangemaaktOp;
    String omschrijving;
    String uniekeId;
}
