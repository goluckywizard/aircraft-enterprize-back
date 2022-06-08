package com.nsu.aircraftenterprize.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "worker")
@Getter
@Setter
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private EmployeeCategory employeeCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    public Worker(String lastName, String firstName, EmployeeCategory employeeCategory) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.employeeCategory = employeeCategory;
    }

    public Worker(String lastName, String firstName, String patronymic, EmployeeCategory employeeCategory) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.employeeCategory = employeeCategory;
    }

    public Worker(String lastName, String firstName, String patronymic, EmployeeCategory employeeCategory, Brigade brigade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.employeeCategory = employeeCategory;
        this.brigade = brigade;
    }
}
