package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Brigade;
import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.entity.Worker;
import com.nsu.aircraftenterprize.repository.BrigadeRepository;
import com.nsu.aircraftenterprize.repository.EmployeeCategoryRepository;
import com.nsu.aircraftenterprize.repository.WorkerRepository;
import com.nsu.aircraftenterprize.rest.WorkerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    EmployeeCategoryRepository categoryRepository;
    @Autowired
    BrigadeRepository brigadeRepository;

    public List<Worker> getAllWorkers() throws Exception {
        return (List<Worker>) workerRepository.findAll();
    }
    public List<Worker> getWorkersByCategory(Long category_id) {
        EmployeeCategory category = categoryRepository.findById(category_id).get();
        return workerRepository.findByEmployeeCategory(category);
    }
    public List<Worker> getWorkerByBrigade(Long brigade_id) {
        Brigade brigade = brigadeRepository.findById(brigade_id).get();
        return workerRepository.findByBrigade(brigade);
    }
    public void addWorker(WorkerRequestDTO request) {
        Worker worker = new Worker();
        Brigade brigade = brigadeRepository.findById(request.getBrigade_id()).get();
        EmployeeCategory category = categoryRepository.findById(request.getCategory_id()).get();

        worker.setBrigade(brigade);
        worker.setEmployeeCategory(category);
        worker.setLastName(request.getLastName());
        worker.setFirstName(request.getFirstName());
        worker.setPatronymic(request.getPatronymic());

        workerRepository.save(worker);
    }
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
