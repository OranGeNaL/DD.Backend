package com.diplom.diplom.model;

import com.diplom.diplom.SystemGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private SystemGroup systemGroup;

    @NotBlank
    @Column(nullable = false)
    private String fio;

    @NotBlank
    @Column(nullable = false, columnDefinition = "varchar(25000)")
    private String message;
}
