package com.diplom.diplom.controller;

import com.diplom.diplom.model.ToDoList;
import com.diplom.diplom.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/to-do-list")
@RequiredArgsConstructor
@Validated
public class ToDoListController {
    private final ToDoListService toDoListService;

    @PostMapping("/{systemName}")
    public void postNewTask(@PathVariable String systemName, @RequestBody ToDoList toDoList) {
        toDoListService.createNewTask(systemName, toDoList);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable UUID id, @RequestBody ToDoList toDoList) {
        toDoListService.updateTask(id, toDoList);
    }

    @GetMapping("/{id}")
    public ToDoList getTask(@PathVariable UUID id) {
        return toDoListService.getTask(id);
    }

    @GetMapping("/all/{systemName}")
    public ResponseEntity<Iterable<ToDoList>> getTasksBySystemName(@PathVariable String systemName) {
        return ResponseEntity.ok(toDoListService.getTasksBySystemName(systemName));
    }
}
