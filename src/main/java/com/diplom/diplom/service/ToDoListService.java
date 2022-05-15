package com.diplom.diplom.service;

import com.diplom.diplom.exception.StatusIsLessThanExceptedException;
import com.diplom.diplom.exception.TaskNotFoundException;
import com.diplom.diplom.model.ToDoList;
import com.diplom.diplom.repository.ToDoListRepository;
import com.diplom.diplom.status.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;

    public void createNewTask(String systemName, ToDoList toDoList) {
        toDoList.setSystemName(systemName);
        toDoListRepository.save(toDoList);
    }

    public void updateTask(UUID id, ToDoList task) {
        ToDoList oldTask = toDoListRepository.findById(id).orElseThrow(TaskNotFoundException::new);
        if (task.getStatus().compareTo(oldTask.getStatus()) < 0) {
            throw new StatusIsLessThanExceptedException();
        }
        task.setId(id);
        task.setSystemName(oldTask.getSystemName());
        task.setCreateTime(oldTask.getCreateTime());
        toDoListRepository.save(task);
    }

    public ToDoList getTask(UUID id) {
        return toDoListRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    public Iterable<ToDoList> getTasksBySystemName(String systemName) {
        return toDoListRepository.findBySystemNameAndStatusBefore(systemName, TaskStatus.DONE);
    }
}
