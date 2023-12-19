package com.test.todo.ToDoApplicatie.mapper;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.util.UUID;

@UtilityClass
public class ToDoMapper {

    public static ToDo mapDTONaarEntity(ToDoDTO toDoDTO) {
        ToDo entity = new ToDo();
        entity.setOmschrijving(toDoDTO.getOmschrijving());
        entity.setAangemaaktOp(Instant.now());
        entity.setUniekeId(UUID.randomUUID().toString());
        return entity;
    }

    public static ToDoDTO mapEntityNaarDTO(ToDo todo) {
        ToDoDTO dto = new ToDoDTO();
        dto.setOmschrijving(todo.getOmschrijving());
        dto.setAangemaaktOp(todo.getAangemaaktOp().toString());
        dto.setUniekeId(todo.getUniekeId());
        return dto;
    }
}
