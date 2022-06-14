package com.nsu.aircraftenterprize.rest.update;

import lombok.Data;

@Data
public class AttributeDTO {
    String attribute;
    String value;
    Long category_id;
}
