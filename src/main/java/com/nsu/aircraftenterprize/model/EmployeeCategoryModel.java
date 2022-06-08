package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import lombok.Data;

@Data
public class EmployeeCategoryModel {
    private Long id;
    private String name;

    public static EmployeeCategoryModel toModel(EmployeeCategory employeeCategory) {
        EmployeeCategoryModel employeeCategoryModel = new EmployeeCategoryModel();
        employeeCategoryModel.setId(employeeCategory.getId());
        employeeCategoryModel.setName(employeeCategory.getName());
        return employeeCategoryModel;
    }
}
