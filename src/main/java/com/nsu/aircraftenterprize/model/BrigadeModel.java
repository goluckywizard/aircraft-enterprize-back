package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Brigade;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrigadeModel {
    private Long id;
    private String name;

    public static BrigadeModel toModel(Brigade brigade) {
        BrigadeModel model = new BrigadeModel();

        model.setId(brigade.getId());
        model.setName(brigade.getName());
        return model;
    }
}
