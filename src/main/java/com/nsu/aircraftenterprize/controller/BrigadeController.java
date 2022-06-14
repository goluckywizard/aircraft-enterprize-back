package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.BrigadeModel;
import com.nsu.aircraftenterprize.model.DepartmentModel;
import com.nsu.aircraftenterprize.rest.BrigadeRequestDTO;
import com.nsu.aircraftenterprize.rest.update.BrigadeDTO;
import com.nsu.aircraftenterprize.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/brigade")
public class BrigadeController {
    @Autowired
    BrigadeService brigadeService;

    @GetMapping
    public ResponseEntity<?> getAllBrigades() {
        try {
            List<BrigadeModel> brigadeModelList = new ArrayList<>();
            brigadeService.getAllBrigades().forEach(brigade -> brigadeModelList.add(BrigadeModel.toModel(brigade)));
            return ResponseEntity.ok(brigadeModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addBrigade(@RequestBody BrigadeRequestDTO request) {
        try {
            brigadeService.addBrigade(request);
            return ResponseEntity.ok("Brigade added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteBrigade(@RequestBody Long brigadeId) {
        try {
            brigadeService.deleteBrigade(brigadeId);
            return ResponseEntity.ok("Brigade deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<?> updateBrigade(@RequestBody BrigadeDTO request) {
        try {
            brigadeService.updateBrigade(request);
            return ResponseEntity.ok("Brigade updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
