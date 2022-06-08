package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class EmployeeAttributeRequestDTO {
    String attribute;
    String value;
    Long category_id;
}
