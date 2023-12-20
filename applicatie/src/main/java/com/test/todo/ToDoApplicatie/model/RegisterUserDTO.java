package com.test.todo.ToDoApplicatie.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserDTO {
    String username;
    String password;
}
