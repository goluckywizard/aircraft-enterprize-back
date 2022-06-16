package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.EmployeeAttribute;
import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.repository.EmployeeAttributeRepository;
import com.nsu.aircraftenterprize.repository.EmployeeCategoryRepository;
import com.nsu.aircraftenterprize.rest.AttributeDELETERequestDTO;
import com.nsu.aircraftenterprize.rest.EmployeeAttributeRequestDTO;
import com.nsu.aircraftenterprize.rest.update.AttributeDTO;
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

    public List<EmployeeAttribute> getAllAttributes() {
        return (List<EmployeeAttribute>) attributeRepository.findAll();
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
    public void deleteAttribute(AttributeDELETERequestDTO request) {
        EmployeeCategory category = categoryRepository.findById(request.getCategoryId()).get();
        EmployeeAttribute attribute = attributeRepository.findByEmployeeCategoryAndAttribute(category, request.getAttribute());
        attributeRepository.delete(attribute);
    }
    public void updateAttribute(AttributeDTO request) {
        EmployeeCategory category = categoryRepository.findById(request.getCategory_id()).get();
        EmployeeAttribute attribute = attributeRepository.findByEmployeeCategoryAndAttribute(category, request.getAttribute());

        attribute.setEmployeeCategoryId(request.getCategory_id());
        attribute.setAttribute(request.getAttribute());
        attribute.setValue(request.getValue());
        attribute.setEmployeeCategory(category);

        attributeRepository.save(attribute);
    }
}
