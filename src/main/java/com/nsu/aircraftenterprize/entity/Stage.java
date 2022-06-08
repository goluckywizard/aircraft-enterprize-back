package com.nsu.aircraftenterprize.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Stage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stage")
    private Set<Work> works;

    public Stage(String name) {
        this.name = name;
    }

    public Stage(String name, Set<Work> works) {
        this.name = name;
        this.works = works;
    }
}
