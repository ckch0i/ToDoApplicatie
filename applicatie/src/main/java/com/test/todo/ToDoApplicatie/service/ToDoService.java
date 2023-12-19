package com.test.todo.ToDoApplicatie.service;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.repository.ToDoRepository;
import com.test.todo.ToDoApplicatie.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.test.todo.ToDoApplicatie.mapper.ToDoMapper.mapDTONaarEntity;
import static com.test.todo.ToDoApplicatie.mapper.ToDoMapper.mapEntityNaarDTO;

@Service
public class ToDoService {

    @Resource
    ToDoRepository toDoRepository;

    @Resource
    UserRepository userRepository;

    public ToDoDTO maakDTO(ToDoDTO toDoDTO, Authentication authentication) {
        ToDo entity = mapDTONaarEntity(toDoDTO);
        entity.setUser(userRepository.findByusername(authentication.getName()));
        ToDo repositoryResult = toDoRepository.save(entity);
        ToDoDTO result = new ToDoDTO();
        result.setUniekeId(repositoryResult.getUniekeId());
        return result;
    }

    public ToDoDTO zoekToDo(String uniekeId, Authentication authentication) {
        ToDo result = toDoRepository.findByUniekeIdAndUser_username(uniekeId, authentication.getName());
        if (result != null) {
            return mapEntityNaarDTO(result);
        }
        return null;
    }

    public List<ToDoDTO> haalAlleToDo(Authentication authentication) {
        Iterable<ToDo> gevondenToDo = toDoRepository.findAllByUser_username(authentication.getName());
        List<ToDoDTO> result = new ArrayList<>();
        gevondenToDo.forEach(todo -> result.add(mapEntityNaarDTO(todo)));
        return result;
    }

}
