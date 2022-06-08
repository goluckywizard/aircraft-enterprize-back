package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.TestField;
import lombok.Data;

@Data
public class TestFieldModel {
    Long id;
    String name;

    public static TestFieldModel toModel(TestField testField) {
        TestFieldModel model = new TestFieldModel();
        model.setId(testField.getId());
        model.setName(testField.getName());

        return model;
    }
}
