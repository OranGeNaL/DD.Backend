package com.diplom.diplom.model;

import com.diplom.diplom.status.SystemGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table
public class ShiftComposition {
    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SystemGroup systemGroup;


    @NotNull
    @ElementCollection
    @Column(nullable = false)
    List<String> people = new ArrayList<>(4);
}
