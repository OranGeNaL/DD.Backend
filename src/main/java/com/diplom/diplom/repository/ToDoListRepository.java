package com.diplom.diplom.repository;

import com.diplom.diplom.model.ToDoList;
import com.diplom.diplom.status.TaskStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ToDoListRepository extends CrudRepository<ToDoList, UUID> {
    Iterable<ToDoList> findBySystemNameAndStatusBefore(String systemName, TaskStatus status);
}
