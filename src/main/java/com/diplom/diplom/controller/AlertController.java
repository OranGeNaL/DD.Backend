package com.diplom.diplom.controller;

import com.diplom.diplom.model.Alert;
import com.diplom.diplom.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
@Validated
public class AlertController {

    private final AlertService alertService;


    @PostMapping("/new")
    public void createNewAlert(@RequestBody Alert alert) {
        //TODO
    }

    @PutMapping("/{id}")
    public void updateAlert(@PathVariable int id, @RequestBody Alert alert) {
        //TODO
    }

    @GetMapping("/{id}")
    public Alert getAlert(@PathVariable int id) {
        //TODO
        return null;
    }

    @GetMapping("/all/{idSystem}")
    public ResponseEntity<Iterable<Alert>> getAllAlertsBySystem(@PathVariable int idSystem) {
        //TODO
        return null;
    }
}
