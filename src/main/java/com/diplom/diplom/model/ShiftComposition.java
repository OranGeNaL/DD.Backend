package com.diplom.diplom.model;

import com.diplom.diplom.SystemGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class ShiftComposition {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private SystemGroup systemGroup;

    @NotNull
    @Column(nullable = false)
    private String fio;
}
