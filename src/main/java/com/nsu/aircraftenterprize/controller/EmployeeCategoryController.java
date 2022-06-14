package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.EmployeeCategoryModel;
import com.nsu.aircraftenterprize.rest.EmployeeCategoryRequestDTO;
import com.nsu.aircraftenterprize.rest.update.EmployeeCategoryDTO;
import com.nsu.aircraftenterprize.service.EmployeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/employee-category")
public class EmployeeCategoryController {
    @Autowired
    EmployeeCategoryService employeeCategoryService;

    @GetMapping
    public ResponseEntity<?> getEmployeeCategories() {
        try {
            List<EmployeeCategoryModel> employeeCategoryModels = new ArrayList<>();
            employeeCategoryService.getAllEmployeeCategories().forEach(employeeCategory -> employeeCategoryModels.add(EmployeeCategoryModel.toModel(employeeCategory)));
            return ResponseEntity.ok(employeeCategoryModels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addEmployeeCategory(@RequestBody EmployeeCategoryRequestDTO request) {
        try {
            employeeCategoryService.addEmployeeCategory(request);
            return ResponseEntity.ok("Employee category added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@RequestBody Long categoryId) {
        try {
            employeeCategoryService.deleteCategory(categoryId);
            return ResponseEntity.ok("Category deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<?> updateEmployeeCategory(@RequestBody EmployeeCategoryDTO request) {
        try {
            employeeCategoryService.updateCategory(request.getId(), request);
            return ResponseEntity.ok("Employee category updated");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
