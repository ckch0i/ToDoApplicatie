package com.test.todo.ToDoApplicatie.repository;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    List<ToDo> findAllByUser_username(String username);

    ToDo findByUniekeIdAndUser_username(String uniekeId, String username);
}
