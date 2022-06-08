package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCategoryRepository extends CrudRepository<EmployeeCategory, Long> {
    EmployeeCategory findByName(String name);

}
