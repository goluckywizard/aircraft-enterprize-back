package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.EmployeeAttribute;
import lombok.Data;

@Data
public class EmployeeAttributeModel {
    String attribute;
    String value;
    Long category_id;
    String category_name;

    public static EmployeeAttributeModel toModel(EmployeeAttribute employeeAttribute) {
        EmployeeAttributeModel model = new EmployeeAttributeModel();
        model.setAttribute(employeeAttribute.getAttribute());
        model.setValue(employeeAttribute.getValue());
        model.setCategory_id(employeeAttribute.getEmployeeCategoryId());
        model.setCategory_name(employeeAttribute.getEmployeeCategory().getName());
        return model;
    }
}
