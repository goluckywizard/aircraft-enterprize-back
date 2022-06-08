package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Brigade;
import com.nsu.aircraftenterprize.entity.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrigadeRepository extends CrudRepository<Brigade, Long> {
    Brigade findByName(String name);
    Brigade findByWorkersContains(Worker worker);
}
