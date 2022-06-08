package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.DepartmentModel;
import com.nsu.aircraftenterprize.model.EmployeeAttributeModel;
import com.nsu.aircraftenterprize.rest.DepartmentRequestDTO;
import com.nsu.aircraftenterprize.rest.EmployeeAttributeGETRequestDTO;
import com.nsu.aircraftenterprize.rest.EmployeeAttributeRequestDTO;
import com.nsu.aircraftenterprize.service.EmployeeAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/employee-attribute")
public class EmployeeAttributeController {
    @Autowired
    EmployeeAttributeService service;

    @GetMapping("/{category_id}")
    public ResponseEntity<?> getAttributes(@PathVariable Long category_id) {
        try {
            List<EmployeeAttributeModel> employeeAttributeModelList = new ArrayList<>();
            service.getAllAttributesByCategory(category_id).forEach(employeeAttribute -> employeeAttributeModelList.add(EmployeeAttributeModel.toModel(employeeAttribute)));
            return ResponseEntity.ok(employeeAttributeModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addAttribute(@RequestBody EmployeeAttributeRequestDTO request) {
        try {
            service.addAttribute(request);
            return ResponseEntity.ok("Employee attribute added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
