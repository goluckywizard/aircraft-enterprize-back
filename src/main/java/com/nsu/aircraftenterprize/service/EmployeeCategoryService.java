package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.repository.EmployeeCategoryRepository;
import com.nsu.aircraftenterprize.rest.EmployeeCategoryRequestDTO;
import com.nsu.aircraftenterprize.rest.update.EmployeeCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCategoryService {
    @Autowired
    EmployeeCategoryRepository employeeCategoryRepository;

    public List<EmployeeCategory> getAllEmployeeCategories() {
        return (List<EmployeeCategory>) employeeCategoryRepository.findAll();
    }
    public void addEmployeeCategory(EmployeeCategoryRequestDTO dto) {
        EmployeeCategory employeeCategory = new EmployeeCategory();
        employeeCategory.setName(dto.getName());
        employeeCategoryRepository.save(employeeCategory);
    }
    public void deleteCategory(Long categoryId) {
        employeeCategoryRepository.deleteById(categoryId);
    }
    public void updateCategory(Long categoryId, EmployeeCategoryDTO dto) {
        EmployeeCategory employeeCategory = employeeCategoryRepository.findById(categoryId).get();
        employeeCategory.setName(dto.getName());
        employeeCategoryRepository.save(employeeCategory);
    }
}
