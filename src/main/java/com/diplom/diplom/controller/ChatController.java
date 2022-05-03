package com.diplom.diplom.controller;

import com.diplom.diplom.model.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Validated
public class ChatController {
    private final ChatController chatController;

    @PostMapping("/{idSystem}")
    public void addMessage(@PathVariable int idSystem, @RequestBody Chat chat) {
        //TODO
    }

    @GetMapping("/{idSystem}")
    public ResponseEntity<Iterable<Chat>> getAllMessageBySystem(@PathVariable int idSystem) {
        //TODO
        return null;
    }
}
