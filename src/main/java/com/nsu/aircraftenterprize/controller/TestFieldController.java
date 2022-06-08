package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.StageModel;
import com.nsu.aircraftenterprize.model.TestFieldModel;
import com.nsu.aircraftenterprize.repository.TestFieldRepository;
import com.nsu.aircraftenterprize.rest.TestFieldDTO;
import com.nsu.aircraftenterprize.service.TestFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/testfield")
public class TestFieldController {
    @Autowired
    TestFieldService fieldService;

    @PostMapping
    public ResponseEntity<?> addTestField(@RequestBody TestFieldDTO request) {
        try {
            fieldService.addTestField(request);
            return ResponseEntity.ok("Test field added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllTestFields() {
        try {
            List<TestFieldModel> testFieldModels = new ArrayList<>();
            fieldService.getAllTestFields().forEach(testField -> testFieldModels.add(TestFieldModel.toModel(testField)));
            return ResponseEntity.ok(testFieldModels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
