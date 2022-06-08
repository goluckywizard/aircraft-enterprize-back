package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Stage;
import lombok.Data;

@Data
public class StageModel {
    private Long id;
    private String name;

    public static StageModel toModel(Stage stage) {
        StageModel model = new StageModel();
        model.setId(stage.getId());
        model.setName(stage.getName());
        return model;
    }
}
