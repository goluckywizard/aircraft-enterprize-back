package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.EngineerModel;
import com.nsu.aircraftenterprize.rest.EngineerRequestDTO;
import com.nsu.aircraftenterprize.rest.EngineersGETRequestByCategoryDTO;
import com.nsu.aircraftenterprize.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/engineer")
public class EngineersController {
    @Autowired
    EngineerService engineerService;

    @GetMapping
    public ResponseEntity<?> getEngineers() {
        try {
            List<EngineerModel> engineerModelList = new ArrayList<>();
            engineerService.getAllEngineers().forEach(engineer -> engineerModelList.add(EngineerModel.toModel(engineer)));
            return ResponseEntity.ok(engineerModelList);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{category_id}")
    public ResponseEntity<?> getEngineersByCategory(@PathVariable Long category_id) {
        System.out.println(category_id);
        try {
            List<EngineerModel> engineerModelList = new ArrayList<>();
            engineerService.getEngineersByCategory(category_id).forEach(engineer -> engineerModelList.add(EngineerModel.toModel(engineer)));
            return ResponseEntity.ok(engineerModelList);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addEngineer(@RequestBody EngineerRequestDTO request) {
        try {
            engineerService.addEngineer(request);
            return ResponseEntity.ok("Engineer added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteEngineer(@RequestBody Long engineerId) {
        try {
            engineerService.deleteEngineer(engineerId);
            return ResponseEntity.ok("Engineer deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
