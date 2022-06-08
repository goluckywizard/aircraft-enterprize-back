package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.entity.Engineer;
import com.nsu.aircraftenterprize.repository.EmployeeCategoryRepository;
import com.nsu.aircraftenterprize.repository.EngineerRepository;
import com.nsu.aircraftenterprize.rest.EngineerRequestDTO;
import com.nsu.aircraftenterprize.rest.EngineersGETRequestByCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerService {
    @Autowired
    EngineerRepository engineerRepository;
    @Autowired
    EmployeeCategoryRepository categoryRepository;

    public void addEngineer(EngineerRequestDTO request) {
        EmployeeCategory category = categoryRepository.findById(request.getCategory_id()).get();
        System.out.println(category);

        Engineer engineer = new Engineer();
        engineer.setLastName(request.getLastName());
        engineer.setFirstName(request.getFirstName());
        engineer.setPatronymic(request.getPatronymic());
        engineer.setEmployeeCategory(category);

        System.out.println(engineer.getEmployeeCategory());
        engineerRepository.save(engineer);
    }
    public List<Engineer> getAllEngineers() {
        return (List<Engineer>) engineerRepository.findAll();
    }
    public List<Engineer> getEngineersByCategory(Long category_id) {
        EmployeeCategory category = categoryRepository.findById(category_id).get();
        System.out.println(category);
        return engineerRepository.findByEmployeeCategory(category);
    }
    public void deleteEngineer(Long id) {
        Engineer engineer = engineerRepository.findById(id).get();
        engineerRepository.delete(engineer);
    }
}
