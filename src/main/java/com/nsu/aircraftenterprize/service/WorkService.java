package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.*;
import com.nsu.aircraftenterprize.repository.*;
import com.nsu.aircraftenterprize.rest.ProductRequestDTO;
import com.nsu.aircraftenterprize.rest.WorkRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;
    @Autowired
    BrigadeRepository brigadeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StageRepository stageRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Work> getAllWork() throws Exception {
        return (List<Work>) workRepository.findAll();
    }
    public List<Work> getWorksByBrigade(Long brigade_id) {
        Brigade brigade = brigadeRepository.findById(brigade_id).get();
        return workRepository.findByBrigade(brigade);
    }
    public List<Work> getWorksByDepartment(Long department_id) {
        Department department = departmentRepository.findById(department_id).get();
        return workRepository.findByDepartment(department);
    }
    public void addWork(WorkRequestDTO request) {
        Brigade brigade = brigadeRepository.findById(request.getBrigade_id()).get();
        Department department = departmentRepository.findById(request.getDepartmentId()).get();
        Stage stage = stageRepository.findById(request.getStage_id()).get();
        /*Set<Product> productSet = new HashSet<>();
        for (var p : request.getProducts()) {
            productSet.add(productRepository.findById(p).get());
        }*/
        Work work = new Work();
        work.setBrigade(brigade);
        work.setDepartment(department);
        work.setStage(stage);
//        work.setProducts(productSet);

        workRepository.save(work);
    }
    public void addProductToWork(Long workId, Long productId) {
        Work work = workRepository.findById(workId).get();
        Product product = productRepository.findById(productId).get();
        work.getProducts().add(product);

        workRepository.save(work);
    }
    public void deleteWork(Long workId) {
        workRepository.deleteById(workId);
    }
}
