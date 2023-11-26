package com.test.todo.ToDoApplicatie.service;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.repository.ToDoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.test.todo.ToDoApplicatie.mapper.ToDoMapper.mapDTONaarEntity;
import static com.test.todo.ToDoApplicatie.mapper.ToDoMapper.mapEntityNaarDTO;

@Service
public class ToDoService {

    @Resource
    ToDoRepository repository;

    public ToDoDTO maakDTO(ToDoDTO toDoDTO) {
        ToDo entity = mapDTONaarEntity(toDoDTO);
        ToDo repositoryResult = repository.save(entity);
        ToDoDTO result = new ToDoDTO();
        result.setUniekeId(repositoryResult.getUniekeId());
        return result;
    }

    public ToDoDTO zoekToDo(String uniekeId) {
        ToDo result = repository.findByUniekeId(uniekeId);
        if (result != null) {
            return mapEntityNaarDTO(result);
        }
        return null;
    }

    public List<ToDoDTO> haalAlleToDo() {
        Iterable<ToDo> gevondenToDo = repository.findAll();
        List<ToDoDTO> result = new ArrayList<>();
        gevondenToDo.forEach(todo -> result.add(mapEntityNaarDTO(todo)));
        return result;
    }

}
