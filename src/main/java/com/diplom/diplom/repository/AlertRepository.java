package com.diplom.diplom.repository;

import com.diplom.diplom.status.SystemGroup;
import com.diplom.diplom.model.Alert;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AlertRepository extends CrudRepository<Alert, UUID> {
    Iterable<Alert> findAllByIdSystemAndDateBetween(SystemGroup idSystem, LocalDateTime dateBefore, LocalDateTime now);
}
