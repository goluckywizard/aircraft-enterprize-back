package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.entity.Department;
import com.nsu.aircraftenterprize.model.DepartmentModel;
import com.nsu.aircraftenterprize.rest.DepartmentRequestDTO;
import com.nsu.aircraftenterprize.rest.update.DepartmentDTO;
import com.nsu.aircraftenterprize.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getDepartments() {
        try {
            List<DepartmentModel> departmentModelList = new ArrayList<>();
            departmentService.getAllDepartments().forEach(department -> departmentModelList.add(DepartmentModel.toModel(department)));
            return ResponseEntity.ok(departmentModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentRequestDTO request) {
        try {
            departmentService.addDepartment(request);
            return ResponseEntity.ok("Department added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteDepartment(@RequestBody Long departmentId) {
        try {
            departmentService.deleteDepartment(departmentId);
            return ResponseEntity.ok("Department deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDTO request) {
        try {
            departmentService.updateDepartment(request.getId(), request);
            return ResponseEntity.ok("Department updated");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
