package com.test.todo.ToDoApplicatie.repository;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    ToDo findByUniekeId(String uniekeId);
}
