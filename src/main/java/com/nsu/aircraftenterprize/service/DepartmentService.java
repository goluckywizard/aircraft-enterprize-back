package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Department;
import com.nsu.aircraftenterprize.model.DepartmentModel;
import com.nsu.aircraftenterprize.repository.DepartmentRepository;
import com.nsu.aircraftenterprize.repository.ManufactureRepository;
import com.nsu.aircraftenterprize.rest.DepartmentRequestDTO;
import com.nsu.aircraftenterprize.rest.update.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ManufactureRepository manufactureRepository;

    public List<Department> getAllDepartments() throws Exception {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        return departments;
    }

    public void addDepartment(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setManufacture(manufactureRepository.findById(dto.getManufacture_id()).get());
        department.setName(dto.getName());
        departmentRepository.save(department);
    }
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        departmentRepository.delete(department);
    }
    public void updateDepartment(Long id, DepartmentDTO dto) {
        Department department = departmentRepository.findById(id).get();
        department.setManufacture(manufactureRepository.findById(dto.getManufacture_id()).get());
        department.setName(dto.getName());
        departmentRepository.save(department);
    }
}
