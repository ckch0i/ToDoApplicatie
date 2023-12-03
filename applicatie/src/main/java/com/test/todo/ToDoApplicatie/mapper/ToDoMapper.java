package com.test.todo.ToDoApplicatie.mapper;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.util.InstantUtils;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.util.UUID;

@UtilityClass
public class ToDoMapper {

    public static ToDo mapDTONaarEntity(ToDoDTO toDoDTO) {
        ToDo entity = new ToDo();
        entity.setOmschrijving(toDoDTO.getOmschrijving());
        entity.setAangemaaktOp(Instant.now());
        entity.setVerlooptOp(InstantUtils.zetStringOmNaarinstant(toDoDTO.getVerlooptOp()));
        entity.setStatus(InstantUtils.isInstantInHetVerleden(InstantUtils.zetStringOmNaarinstant(toDoDTO.getVerlooptOp())) ? ToDoDTO.Status.VERLOPEN.name() : ToDoDTO.Status.ACTIEF.name());
        entity.setUniekeId(UUID.randomUUID().toString());
        return entity;
    }

    public static ToDoDTO mapEntityNaarDTO(ToDo todo) {
        ToDoDTO dto = new ToDoDTO();
        dto.setOmschrijving(todo.getOmschrijving());
        dto.setAangemaaktDatum(InstantUtils.zetInstantOmNaarString(todo.getAangemaaktOp()));
        dto.setVerlooptOp(InstantUtils.zetInstantOmNaarString(todo.getVerlooptOp()));
        dto.setStatus(InstantUtils.isInstantInHetVerleden(todo.getVerlooptOp()) ? ToDoDTO.Status.VERLOPEN : ToDoDTO.Status.ACTIEF);
        dto.setUniekeId(todo.getUniekeId());
        return dto;
    }

}
