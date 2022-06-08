package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.EmployeeAttribute;
import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.repository.EmployeeAttributeRepository;
import com.nsu.aircraftenterprize.repository.EmployeeCategoryRepository;
import com.nsu.aircraftenterprize.rest.EmployeeAttributeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAttributeService {
    @Autowired
    EmployeeAttributeRepository attributeRepository;
    @Autowired
    EmployeeCategoryRepository categoryRepository;

    public List<EmployeeAttribute> getAllAttributesByCategory(Long categoryId) {
        EmployeeCategory category = categoryRepository.findById(categoryId).get();
        return attributeRepository.findAllByEmployeeCategory(category);
    }

    public void addAttribute(EmployeeAttributeRequestDTO request) {
        EmployeeCategory category = categoryRepository.findById(request.getCategory_id()).get();
        EmployeeAttribute employeeAttribute = new EmployeeAttribute();

        employeeAttribute.setEmployeeCategoryId(request.getCategory_id());
        employeeAttribute.setAttribute(request.getAttribute());
        employeeAttribute.setValue(request.getValue());
        employeeAttribute.setEmployeeCategory(category);

        attributeRepository.save(employeeAttribute);
    }
}
