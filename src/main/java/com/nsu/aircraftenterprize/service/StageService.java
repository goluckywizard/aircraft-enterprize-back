package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Stage;
import com.nsu.aircraftenterprize.repository.StageRepository;
import com.nsu.aircraftenterprize.rest.StageRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {
    @Autowired
    StageRepository stageRepository;

    public List<Stage> getAllStages() throws Exception {
        return (List<Stage>) stageRepository.findAll();
    }
    public void addStage(StageRequestDTO request) {
        Stage stage = new Stage();
        System.out.println(request.getName());
        stage.setName(request.getName());

        stageRepository.save(stage);
    }
    public void deleteStage(Long stageId) {
        stageRepository.deleteById(stageId);
    }

}
