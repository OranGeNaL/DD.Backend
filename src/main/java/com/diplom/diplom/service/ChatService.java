package com.diplom.diplom.service;

import com.diplom.diplom.status.SystemGroup;
import com.diplom.diplom.model.Chat;
import com.diplom.diplom.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public void addMessage(String systemName, String fio, String message) {
        Chat chat = new Chat();
        chat.setSystemGroup(SystemGroup.valueOf(systemName));
        chat.setFio(fio);
        chat.setMessage(message);
        chatRepository.save(chat);
    }

    public Iterable<Chat> getAllMessageBySystem(String systemName) {
        return chatRepository.findAllBySystemGroupAndDateBetween(SystemGroup.valueOf(systemName),
                LocalDateTime.now().minusHours(12),
                LocalDateTime.now());
    }
}
