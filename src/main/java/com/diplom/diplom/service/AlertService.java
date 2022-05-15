package com.diplom.diplom.service;

import com.diplom.diplom.exception.StatusIsLessThanExceptedException;
import com.diplom.diplom.status.SystemGroup;
import com.diplom.diplom.exception.AlertNotFoundException;
import com.diplom.diplom.model.Alert;
import com.diplom.diplom.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;

    public void createAlert(Alert alert) {
        alertRepository.save(alert);
    }


    public void updateAlert(UUID id, Alert alert) {
        Alert oldAlert = alertRepository.findById(id).orElseThrow(AlertNotFoundException::new);
        if (alert.getStatus().compareTo(oldAlert.getStatus()) < 0) {
            throw new StatusIsLessThanExceptedException();
        }
        alert.setId(id);
        alert.setDate(oldAlert.getDate());
        alertRepository.save(alert);
    }

    public Alert getAlert(UUID id) {
        return alertRepository.findById(id)
                .orElseThrow(AlertNotFoundException::new);
    }

    public Iterable<Alert> getAllBySystem(String nameSystem) {
        return alertRepository.findAllByIdSystemAndDateBetween(SystemGroup.valueOf(nameSystem),
                LocalDateTime.now().minusHours(12),
                LocalDateTime.now());
    }
}
