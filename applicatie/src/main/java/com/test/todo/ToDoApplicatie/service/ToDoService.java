package com.test.todo.ToDoApplicatie.service;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.repository.ToDoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ToDoService {

    @Resource
    ToDoRepository repository;

    public ToDoDTO maakDTO(ToDoDTO toDoDTO){
        ToDo entity = mapDTONaarEntity(toDoDTO);
        ToDo repositoryResult = repository.save(entity);
        ToDoDTO result = new ToDoDTO();
        result.setUniekeId(repositoryResult.getUniekeId());
        return result;
    }

    public ToDoDTO zoekToDo(String uniekeId) {
        ToDo result = repository.findByUniekeId(uniekeId);
        if (result != null){
            return mapEntityNaarDTO(result);
        }
        return null;
    }
    public List<ToDoDTO> haalAlleToDo() {
        Iterable<ToDo> gevondenToDo = repository.findAll();
        List<ToDoDTO> result = new ArrayList<>();
        gevondenToDo.forEach( todo -> result.add(mapEntityNaarDTO(todo)));
        return result;
    }

    private ToDo mapDTONaarEntity(ToDoDTO toDoDTO){
        ToDo entity = new ToDo();
        entity.setOmschrijving(toDoDTO.getOmschrijving());
        entity.setAangemaaktOp(Instant.now());
        entity.setUniekeId(UUID.randomUUID().toString());
        return entity;
    }

    private ToDoDTO mapEntityNaarDTO(ToDo todo){
        ToDoDTO dto = new ToDoDTO();
        dto.setOmschrijving(todo.getOmschrijving());
        dto.setAangemaaktOp(todo.getAangemaaktOp().toString());
        dto.setUniekeId(todo.getUniekeId());
        return dto;
    }

}
