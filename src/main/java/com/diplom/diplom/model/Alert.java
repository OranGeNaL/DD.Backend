package com.diplom.diplom.model;

import com.diplom.diplom.status.AlertStatus;
import com.diplom.diplom.status.SystemGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table
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

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SystemGroup idSystem;

    @NotBlank
    @Column
    private String worker;

    @Column(columnDefinition = "varchar(25000)")
    private String commentToClose;

    @Column
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private AlertStatus status;
}
