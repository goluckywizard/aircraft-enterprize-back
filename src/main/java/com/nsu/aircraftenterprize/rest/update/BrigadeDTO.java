package com.nsu.aircraftenterprize.rest.update;

import lombok.Data;

@Data
public class BrigadeDTO {
    Long id;
    String name;
    Long head_id = null;
}
