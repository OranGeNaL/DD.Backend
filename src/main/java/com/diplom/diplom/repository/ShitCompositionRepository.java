package com.diplom.diplom.repository;

import com.diplom.diplom.model.ShiftComposition;
import com.diplom.diplom.status.SystemGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShitCompositionRepository extends CrudRepository<ShiftComposition, UUID> {
    Iterable<ShiftComposition> findAllBySystemGroup(SystemGroup systemGroup);
    ShiftComposition findBySystemGroup(SystemGroup systemGroup);
}
