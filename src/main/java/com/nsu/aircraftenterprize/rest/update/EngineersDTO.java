package com.nsu.aircraftenterprize.rest.update;

import lombok.Data;

@Data
public class EngineersDTO {
    Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Long category_id;
}
