package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.ManufactureModel;
import com.nsu.aircraftenterprize.rest.ManufactureRequestDTO;
import com.nsu.aircraftenterprize.rest.update.ManufactureDTO;
import com.nsu.aircraftenterprize.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;
    @GetMapping
    public ResponseEntity<?> getManufactures() {
        try {
            List<ManufactureModel> manufactureModelList = new ArrayList<>();
            manufactureService.getAllManufacture().forEach(manufacture -> manufactureModelList.add(ManufactureModel.toModel(manufacture)));
            return ResponseEntity.ok(manufactureModelList);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addManufacture(@RequestBody ManufactureRequestDTO request) {
        try {
            manufactureService.addManufacture(request);
            return ResponseEntity.ok("Manufacture added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteManufacture(@RequestBody Long manufactureId) {
        try {
            manufactureService.deleteManufacture(manufactureId);
            return ResponseEntity.ok("Manufacture deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<?> updateManufacture(@RequestBody ManufactureDTO request) {
        try {
            manufactureService.updateManufacture(request.getId(), request);
            return ResponseEntity.ok("Manufacture updated");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
