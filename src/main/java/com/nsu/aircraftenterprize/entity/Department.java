package com.nsu.aircraftenterprize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "department")
    private Set<Work> works = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "head")
    private Engineer head;

    public Department(Manufacture manufacture, String name) {
        this.manufacture = manufacture;
        this.name = name;
    }

}
