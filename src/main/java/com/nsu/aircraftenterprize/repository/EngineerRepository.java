package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.entity.Engineer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EngineerRepository extends CrudRepository<Engineer, Long> {
    Engineer findByLastNameAndFirstNameOrderByLastNameAsc(String lastName, String firstName);
    List<Engineer> findByEmployeeCategory(EmployeeCategory employeeCategory);
}
