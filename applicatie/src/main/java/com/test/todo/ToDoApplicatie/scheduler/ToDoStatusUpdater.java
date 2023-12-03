package com.test.todo.ToDoApplicatie.scheduler;

import com.test.todo.ToDoApplicatie.entity.ToDo;
import com.test.todo.ToDoApplicatie.model.ToDoDTO;
import com.test.todo.ToDoApplicatie.repository.ToDoRepository;
import com.test.todo.ToDoApplicatie.util.InstantUtils;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToDoStatusUpdater {

    @Resource
    ToDoRepository toDoRepository;

    @Scheduled(fixedRate = 5000)
    public void setAllExpiredToDo(){
        List<ToDo> result = toDoRepository.findByStatusEqualsIgnoreCase(ToDoDTO.Status.ACTIEF.name());
        result.forEach(
                todo -> todo.setStatus(InstantUtils.isInstantInHetVerleden(todo.getVerlooptOp()) ? ToDoDTO.Status.VERLOPEN.name() : ToDoDTO.Status.ACTIEF.name()));
    }
}
