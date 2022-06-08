package com.nsu.aircraftenterprize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empl_category")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeCategory")
    private Set<EmployeeAttribute> employeeAttributes = new HashSet<>();

    public EmployeeCategory(String name, Set<EmployeeAttribute> employeeAttributes) {
        this.name = name;
        this.employeeAttributes = employeeAttributes;
    }
}
