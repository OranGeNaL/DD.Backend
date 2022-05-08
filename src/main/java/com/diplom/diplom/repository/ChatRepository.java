package com.diplom.diplom.repository;

import com.diplom.diplom.status.SystemGroup;
import com.diplom.diplom.model.Chat;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ChatRepository extends CrudRepository<Chat, UUID> {
    Iterable<Chat> findAllBySystemGroupAndDateBetween(SystemGroup systemGroup, LocalDateTime timeStart, LocalDateTime timeEnd);
}
