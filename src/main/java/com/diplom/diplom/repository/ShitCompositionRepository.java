package com.diplom.diplom.repository;

import com.diplom.diplom.model.ShiftComposition;
import com.diplom.diplom.status.SystemGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShitCompositionRepository extends CrudRepository<ShiftComposition, UUID> {
    Iterable<ShiftComposition> findAllBySystemGroup(SystemGroup systemGroup);
    ShiftComposition findBySystemGroup(SystemGroup systemGroup);
}
