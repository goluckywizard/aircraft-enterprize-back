package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class WorkerRequestDTO {
    private String lastName;
    private String firstName;
    private String patronymic;
    private Long category_id;
    private Long brigade_id;
}
