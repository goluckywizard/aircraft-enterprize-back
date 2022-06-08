package com.nsu.aircraftenterprize.rest;

import lombok.Data;

import java.util.List;

@Data
public class TestRequestDTO {
    Long product_id;
    Long engineer_id;
    private List<Long> equipment;
}
