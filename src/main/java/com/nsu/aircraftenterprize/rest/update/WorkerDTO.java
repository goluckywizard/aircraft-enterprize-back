package com.nsu.aircraftenterprize.rest.update;

import lombok.Data;

@Data
public class WorkerDTO {
    Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Long category_id;
    private Long brigade_id;
}
