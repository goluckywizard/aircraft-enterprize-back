package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.StageModel;
import com.nsu.aircraftenterprize.rest.StageRequestDTO;
import com.nsu.aircraftenterprize.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/stage")
public class StageController {
    @Autowired
    StageService stageService;

    @GetMapping
    public ResponseEntity<?> getAllStages() {
        try {
            List<StageModel> stageModelList = new ArrayList<>();
            stageService.getAllStages().forEach(stage -> stageModelList.add(StageModel.toModel(stage)));
            return ResponseEntity.ok(stageModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addStage(@RequestBody StageRequestDTO request) {
        try {
            System.out.println(request);
            stageService.addStage(request);
            return ResponseEntity.ok("Stage added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteStage(@RequestBody Long id) {
        try {
            stageService.deleteStage(id);
            return ResponseEntity.ok("Stage deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
