package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.TestEquipmentModel;
import com.nsu.aircraftenterprize.model.TestFieldModel;
import com.nsu.aircraftenterprize.rest.TestEquipmentRequestDTO;
import com.nsu.aircraftenterprize.rest.update.EquipmentDTO;
import com.nsu.aircraftenterprize.service.TestEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/test-equipment")
public class TestEquipmentController {
    @Autowired
    TestEquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<?> getAllEquipment() {
        try {
            List<TestEquipmentModel> equipmentModelList = new ArrayList<>();
            equipmentService.getAllEquipment().forEach(equipment -> equipmentModelList.add(TestEquipmentModel.toModel(equipment)));
            return ResponseEntity.ok(equipmentModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addEquipment(@RequestBody TestEquipmentRequestDTO request) {
        try {
            equipmentService.addEquipment(request);
            return ResponseEntity.ok("Test equipment added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteField(@RequestBody Long id) {
        try {
            equipmentService.deleteEquipment(id);
            return ResponseEntity.ok("Test equipment deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<?> updateEquipment(@RequestBody EquipmentDTO request) {
        try {
            equipmentService.updateEquipment(request.getId(), request);
            return ResponseEntity.ok("Test equipment updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
