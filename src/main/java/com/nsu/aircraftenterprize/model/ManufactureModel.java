package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Manufacture;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ManufactureModel {
    Long id;
    private String name;
    private Set<DepartmentModel> departments = new HashSet<>();

    public static ManufactureModel toModel(Manufacture manufacture) {
        ManufactureModel model = new ManufactureModel();
        model.setId(manufacture.getId());
        model.setName(manufacture.getName());
        manufacture.getDepartments().forEach(department -> model.getDepartments().add(DepartmentModel.toModel(department)));
        return model;
    }
}
