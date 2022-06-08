package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Brigade;
import com.nsu.aircraftenterprize.entity.Department;
import com.nsu.aircraftenterprize.entity.Stage;
import com.nsu.aircraftenterprize.entity.Work;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkRepository extends CrudRepository<Work, Long> {
    List<Work> findByDepartment(Department department);
    List<Work> findByBrigade(Brigade brigade);
    List<Work> findByStage(Stage stage);
}
