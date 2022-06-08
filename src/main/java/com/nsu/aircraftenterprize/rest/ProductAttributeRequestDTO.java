package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class ProductAttributeRequestDTO {
    String attribute;
    String value;
    Long category_id;
}