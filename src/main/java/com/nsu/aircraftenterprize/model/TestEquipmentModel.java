package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.TestEquipment;
import lombok.Data;

@Data
public class TestEquipmentModel {
    private Long id;
    private String name;

    private TestFieldModel field;

    public static TestEquipmentModel toModel(TestEquipment testEquipment) {
        TestEquipmentModel model = new TestEquipmentModel();
        model.setId(testEquipment.getId());
        model.setName(testEquipment.getName());
        model.setField(TestFieldModel.toModel(testEquipment.getTestField()));
        return model;
    }
}
