package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Engineer;
import lombok.Data;

@Data
public class EngineerModel {
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Long category_id;
    private String category_name;

    public static EngineerModel toModel(Engineer engineer) {
        EngineerModel model = new EngineerModel();
        model.setId(engineer.getId());
        model.setLastName(engineer.getLastName());
        model.setFirstName(engineer.getFirstName());
        model.setPatronymic(engineer.getPatronymic());
        model.setCategory_id(engineer.getEmployeeCategory().getId());
        model.setCategory_name(engineer.getEmployeeCategory().getName());
        return model;
    }
}
