package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.TestFieldModel;
import com.nsu.aircraftenterprize.model.WorkerModel;
import com.nsu.aircraftenterprize.rest.TestEquipmentRequestDTO;
import com.nsu.aircraftenterprize.rest.WorkerRequestDTO;
import com.nsu.aircraftenterprize.rest.update.WorkerDTO;
import com.nsu.aircraftenterprize.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping
    public ResponseEntity<?> getAllWorkers() {
        try {
            List<WorkerModel> workerModelList = new ArrayList<>();
            workerService.getAllWorkers().forEach(worker -> workerModelList.add(WorkerModel.toModel(worker)));
            return ResponseEntity.ok(workerModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addWorker(@RequestBody WorkerRequestDTO request) {
        try {
            workerService.addWorker(request);
            return ResponseEntity.ok("Worker added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteWorker(@RequestBody Long id) {
        try {
            workerService.deleteWorker(id);
            return ResponseEntity.ok("Worker deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<?> updateWorker(@RequestBody WorkerDTO request) {
        try {
            System.out.println(request.toString());
            workerService.updateWorker(request.getId(), request);
            return ResponseEntity.ok("Worker updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
