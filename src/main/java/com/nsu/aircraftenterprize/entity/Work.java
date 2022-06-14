package com.nsu.aircraftenterprize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stage_id")
    private Stage stage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "prod_in_work",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "work_id")
    )
    private Set<Product> products = new HashSet<>();
}
