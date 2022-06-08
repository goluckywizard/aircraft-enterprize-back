package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Department;
import com.nsu.aircraftenterprize.entity.Manufacture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByName(String name);
    List<Department> findAllByManufacture(Manufacture manufacture);

}
