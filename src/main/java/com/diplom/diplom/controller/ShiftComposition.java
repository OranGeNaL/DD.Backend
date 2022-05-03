package com.diplom.diplom.controller;

import com.diplom.diplom.service.ShiftCompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
@Validated
public class ShiftComposition {
    private final ShiftCompositionService shiftCompositionService;

    @PutMapping("/{idSystem}")
    public void takePlace(@PathVariable int idSystem,
                          @RequestParam int slotInd,
                          @RequestBody ShiftComposition composition) {
        //TODO
    }

    @GetMapping("/all/{idSystem}")
    public ResponseEntity<Iterable<ShiftComposition>> getAllPeopleBySystem(@PathVariable int idSystem) {
        //TODO
        return null;
    }
}
