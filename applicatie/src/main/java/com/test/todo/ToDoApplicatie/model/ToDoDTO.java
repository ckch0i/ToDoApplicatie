package com.test.todo.ToDoApplicatie.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToDoDTO {
    String uniekeId;
    String omschrijving;
    String aangemaaktDatum;
    String verlooptOp;
    Status status;

    public enum Status {
        ACTIEF, VERLOPEN
    }
}
