package com.diplom.diplom.model;

import com.diplom.diplom.status.SystemGroup;
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
public class ShiftComposition {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private SystemGroup systemGroup;


    @NotNull
    @ElementCollection
    @Column(nullable = false)
    List<String> people = new ArrayList<>(4);
}
