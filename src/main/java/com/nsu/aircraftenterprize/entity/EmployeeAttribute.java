package com.nsu.aircraftenterprize.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

@Table(name = "empl_attr")
@IdClass(EmployeeAttributeKey.class)
public class EmployeeAttribute {
    @Id
    @Column(name = "category_id")
    private Long employeeCategoryId;
    @Id
    private String attribute;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private EmployeeCategory employeeCategory;


    private String value;


}
