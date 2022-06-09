package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.EmployeeAttribute;
import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeAttributeRepository extends CrudRepository<EmployeeAttribute, Long> {
    EmployeeAttribute findByAttribute(String attribute);
    List<EmployeeAttribute> findAllByEmployeeCategory(EmployeeCategory employeeCategory);
    EmployeeAttribute findByEmployeeCategoryAndAttribute(EmployeeCategory employeeCategory, String attribute);
}
