package com.test.todo.ToDoApplicatie.repository;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    ToDo findByUniekeId(String uniekeId);

    List<ToDo> findByStatusEqualsIgnoreCase(String status);
}
