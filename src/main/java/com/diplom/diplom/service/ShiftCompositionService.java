package com.diplom.diplom.service;

import com.diplom.diplom.model.ShiftComposition;
import com.diplom.diplom.repository.ShitCompositionRepository;
import com.diplom.diplom.status.SystemGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShiftCompositionService {

    private final ShitCompositionRepository shitCompositionRepository;

    public void takePlace(SystemGroup systemName, int slotInd, String fio) {
        ShiftComposition shiftComposition = shitCompositionRepository.findBySystemGroup(systemName);
        if (shiftComposition == null) {
            shiftComposition = new ShiftComposition();
            shiftComposition.setSystemGroup(systemName);
        }
        shiftComposition.getPeople().add(slotInd, fio);
        shitCompositionRepository.save(shiftComposition);
    }

    public Iterable<ShiftComposition> getAllBySystem(SystemGroup systemName) {
        return shitCompositionRepository.findAllBySystemGroup(systemName);
    }
}
