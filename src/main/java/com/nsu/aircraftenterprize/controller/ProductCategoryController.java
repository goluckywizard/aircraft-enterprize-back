package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.EmployeeCategoryModel;
import com.nsu.aircraftenterprize.model.ProductCategoryModel;
import com.nsu.aircraftenterprize.rest.EmployeeCategoryRequestDTO;
import com.nsu.aircraftenterprize.rest.ProductCategoryRequestDTO;
import com.nsu.aircraftenterprize.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<?> getProductCategories() {
        try {
            List<ProductCategoryModel> productCategoryModels = new ArrayList<>();
            productCategoryService.getAllProductCategories().forEach(productCategory -> productCategoryModels.add(ProductCategoryModel.toModel(productCategory)));
            return ResponseEntity.ok(productCategoryModels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addProductCategory(@RequestBody ProductCategoryRequestDTO request) {
        try {
            productCategoryService.addProductCategory(request);
            return ResponseEntity.ok("Product category added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@RequestBody Long categoryId) {
        try {
            productCategoryService.deleteCategory(categoryId);
            return ResponseEntity.ok("Category deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
