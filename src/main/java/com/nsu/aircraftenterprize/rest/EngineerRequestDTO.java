package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class EngineerRequestDTO {
    private String lastName;
    private String firstName;
    private String patronymic;
    private Long category_id;
}
