package com.nsu.aircraftenterprize.rest;

import lombok.Data;

import java.util.List;

@Data
public class WorkRequestDTO {
    private Long departmentId;
    private Long stage_id;
    private Long brigade_id;
}
