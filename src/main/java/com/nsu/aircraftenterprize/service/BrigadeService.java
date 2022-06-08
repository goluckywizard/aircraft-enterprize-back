package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Brigade;
import com.nsu.aircraftenterprize.entity.Worker;
import com.nsu.aircraftenterprize.repository.BrigadeRepository;
import com.nsu.aircraftenterprize.repository.WorkerRepository;
import com.nsu.aircraftenterprize.rest.BrigadeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrigadeService {
    @Autowired
    BrigadeRepository brigadeRepository;
    @Autowired
    WorkerRepository workerRepository;

    public List<Brigade> getAllBrigades() throws Exception {
        return (List<Brigade>) brigadeRepository.findAll();
    }
    public Brigade getBrigadeById(Long brigade_id) {
        return brigadeRepository.findById(brigade_id).get();
    }
    public void addBrigade(BrigadeRequestDTO request) {
        Brigade brigade = new Brigade();

        Worker worker;
        if (request.getHead_id() != null) {
            worker = workerRepository.findById(request.getHead_id()).get();
        }
        else {
            worker = null;
        }

        brigade.setName(request.getName());
        brigade.setHead(worker);

        brigadeRepository.save(brigade);
    }
    public void deleteBrigade(Long brigadeId) {
        Brigade brigade = brigadeRepository.findById(brigadeId).get();
        brigadeRepository.delete(brigade);
    }
}
