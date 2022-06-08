package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Brigade;
import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.entity.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByLastNameAndFirstNameOrderByLastNameAsc(String lastName, String firstName);
    List<Worker> findByEmployeeCategory(EmployeeCategory employeeCategory);
    List<Worker> findByBrigade(Brigade brigade);
}
