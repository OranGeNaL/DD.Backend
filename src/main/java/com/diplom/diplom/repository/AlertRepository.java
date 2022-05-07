package com.diplom.diplom.repository;

import com.diplom.diplom.SystemGroup;
import com.diplom.diplom.model.Alert;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AlertRepository extends CrudRepository<Alert, UUID> {
    Iterable<Alert> findAllByIdSystem(SystemGroup idSystem);
}
