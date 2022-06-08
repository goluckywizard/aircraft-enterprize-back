package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class ProductTypeRequestDTO {
    private String name;
    private Long category_id;
}
