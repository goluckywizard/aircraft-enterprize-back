package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Department;
import lombok.Data;

@Data
public class DepartmentModel {
    Long id;
    private String name;
    private Long manufactureId;
    private String manufactureName;

    public static DepartmentModel toModel(Department department) {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setId(department.getId());
        departmentModel.setName(department.getName());
        departmentModel.setManufactureId(department.getManufacture().getId());
        departmentModel.setManufactureName(department.getManufacture().getName());
        return departmentModel;
    }
}
