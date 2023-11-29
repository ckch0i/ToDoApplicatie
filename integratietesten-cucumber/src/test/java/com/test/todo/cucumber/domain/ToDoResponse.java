package com.test.todo.cucumber.domain;

import lombok.Getter;
import lombok.Setter;
import java.security.PublicKey;
@Setter
@Getter

public class ToDoResponse {
    public String uniekeId;
    public String omschrijving;
    public String aangemaaktOp;
}
