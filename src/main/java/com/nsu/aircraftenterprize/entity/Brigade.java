package com.nsu.aircraftenterprize.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "brigades")
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Worker head;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brigade")
    private Set<Work> works;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brigade")
    private Set<Worker> workers;

    public Brigade(String name, Worker head) {
        this.name = name;
        this.head = head;
    }
}
