package com.diplom.diplom.service;

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
        if (alertRepository.existsById(id)) {
            throw new AlertNotFoundException();
        }
        alert.setId(id);
        alertRepository.save(alert);
    }

    public Alert getAlert(UUID id) {
        return alertRepository.findById(id)
                .orElseThrow(AlertNotFoundException::new);
    }

    public Iterable<Alert> getAllBySystem(String systemName) {
        return alertRepository.findAllByIdSystemAndDateBetween(SystemGroup.valueOf(systemName),
                LocalDateTime.now().minusHours(12),
                LocalDateTime.now());
    }
}
