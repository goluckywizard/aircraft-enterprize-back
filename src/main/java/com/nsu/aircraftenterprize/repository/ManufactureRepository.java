package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Manufacture;
import org.springframework.data.repository.CrudRepository;

public interface ManufactureRepository extends CrudRepository<Manufacture, Long> {
    Manufacture findByName(String name);
}
