package com.diplom.diplom.model;

import com.diplom.diplom.status.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String systemName;

    @NotNull
    @Column(nullable = false)
    private String nameTask;

    @NotNull
    @Column(nullable = false, columnDefinition = "varchar(2500)")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;

    @NotNull
    @Column
    private String worker;
}
