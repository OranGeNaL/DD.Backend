package com.diplom.diplom.controller;

import com.diplom.diplom.model.ShiftComposition;
import com.diplom.diplom.service.ShiftCompositionService;
import com.diplom.diplom.status.SystemGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
@Validated
public class ShiftCompositionController {
    private final ShiftCompositionService shiftCompositionService;

    @PutMapping("/{systemName}")
    public void takePlace(@PathVariable String systemName,
                          @RequestParam int slotInd,
                          @RequestParam String fio) {
        shiftCompositionService.takePlace(SystemGroup.valueOf(systemName), slotInd, fio);
    }

    @GetMapping("/all/{systemName}")
    public ResponseEntity<Iterable<ShiftComposition>> getAllPeopleBySystem(@PathVariable String systemName) {
        return ResponseEntity.ok(shiftCompositionService.getAllBySystem(SystemGroup.valueOf(systemName)));
    }
}
