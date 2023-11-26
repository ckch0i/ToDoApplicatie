package com.test.todo.ToDoApplicatie.model;

import java.time.Instant;

public record ToDoDTO(String omschrijving, Instant aangemaaktOp) {
}
