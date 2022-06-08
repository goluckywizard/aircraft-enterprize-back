package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Stage;
import com.nsu.aircraftenterprize.entity.Work;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StageRepository extends CrudRepository<Stage, Long> {
    List<Stage> findByName(String name);
    List<Stage> findByWorksContains(Work work);
}
