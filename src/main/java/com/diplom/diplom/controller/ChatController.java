package com.diplom.diplom.controller;

import com.diplom.diplom.model.Chat;
import com.diplom.diplom.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Validated
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/{systemName}")
    public void addMessage(@PathVariable String systemName, @RequestBody Chat chat) {
        chatService.addMessage(systemName, chat.getFio(), chat.getMessage());
    }

    @GetMapping("/{systemName}")
    public ResponseEntity<Iterable<Chat>> getAllMessageBySystem(@PathVariable String systemName) {
        return ResponseEntity.ok(chatService.getAllMessageBySystem(systemName));
    }
}
