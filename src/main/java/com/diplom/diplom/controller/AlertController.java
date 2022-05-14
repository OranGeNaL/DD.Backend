package com.diplom.diplom.controller;

import com.diplom.diplom.model.Alert;
import com.diplom.diplom.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
@Validated
public class AlertController {

    private final AlertService alertService;


    @PostMapping("/new")
    public void createNewAlert(@RequestBody Alert alert) {
        alertService.createAlert(alert);
    }

    @PutMapping("/{id}")
    public void updateAlert(@PathVariable UUID id, @RequestBody Alert alert) {
        alertService.updateAlert(id, alert);
    }

    @GetMapping("/{id}")
    public Alert getAlert(@PathVariable UUID id) {
        return alertService.getAlert(id);
    }

    @GetMapping("/all/{nameSystem}")
    public ResponseEntity<Iterable<Alert>> getAllAlertsBySystem(@PathVariable String nameSystem) {
        return ResponseEntity.ok(alertService.getAllBySystem(nameSystem));
    }
}
