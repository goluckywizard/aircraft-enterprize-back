package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Test;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class TestModel {
    private Long id;
    private Long product_id;
    private Long engineer_id;
    private Set<Long> equipment = new HashSet<>();

    public static TestModel toModel(Test test) {
        TestModel model = new TestModel();
        model.setId(test.getId());
        model.setProduct_id(model.getProduct_id());
        model.setEngineer_id(test.getEngineer().getId());
        for (var t : test.getEquipmentSet()) {
            model.getEquipment().add(t.getId());
        }
        return model;
    }
}
