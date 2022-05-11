package com.diplom.diplom.model;

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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime date;
}
