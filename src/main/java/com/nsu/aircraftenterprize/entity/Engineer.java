package com.nsu.aircraftenterprize.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "engineer")
@Getter
@Setter
@NoArgsConstructor
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private EmployeeCategory employeeCategory;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "engineer")
    private Set<Test> testSet;

    public Engineer(String lastName, String firstName, String patronymic, EmployeeCategory employeeCategory) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.employeeCategory = employeeCategory;
    }
}
