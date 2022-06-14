package com.nsu.aircraftenterprize.rest.update;

import lombok.Data;

@Data
public class TypeDTO {
    Long id;
    private String name;
    private Long category_id;
}
