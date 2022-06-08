package com.nsu.aircraftenterprize.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class EmployeeAttributeKey implements Serializable {
    private Long employeeCategoryId;
    private String attribute;

    public EmployeeAttributeKey() {
    }
}
