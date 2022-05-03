package com.diplom.diplom.model;

import com.diplom.diplom.AlertStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Alert {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "varchar(25000)")
    private String header;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime date;

    @NotBlank
    @Column(nullable = false, columnDefinition = "varchar(25000)")
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String nameSystem;

    @NotBlank
    @Column(nullable = false)
    private String worker;

    @Column(columnDefinition = "varchar(25000)")
    private String commentToClose;

    @Column
    @NotNull
    private AlertStatus status;
}
