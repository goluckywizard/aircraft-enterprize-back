package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.ProductModel;
import com.nsu.aircraftenterprize.model.WorkModel;
import com.nsu.aircraftenterprize.rest.ProductRequestDTO;
import com.nsu.aircraftenterprize.rest.WorkRequestDTO;
import com.nsu.aircraftenterprize.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkService workService;

    @PostMapping
    public ResponseEntity<?> addWork(@RequestBody WorkRequestDTO request) {
        try {
            workService.addWork(request);
            return ResponseEntity.ok("Work added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllWorks() {
        try {
            List<WorkModel> workModelList = new ArrayList<>();
            workService.getAllWork().forEach(work -> workModelList.add(WorkModel.toModel(work)));
            return ResponseEntity.ok(workModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/{workId}/{productId}")
    public ResponseEntity<?> addProductToWork(@PathVariable Long workId, @PathVariable Long productId) {
        try {
            workService.addProductToWork(workId, productId);
            return ResponseEntity.ok("Product to work added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteWork(@RequestBody Long workId) {
        try {
            workService.deleteWork(workId);
            return ResponseEntity.ok("Work deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
