package com.test.todo.ToDoApplicatie.repository;

import com.test.todo.ToDoApplicatie.entity.ToDoUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ToDoUser, Long> {

    ToDoUser findByusername(String username);

}
