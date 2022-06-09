package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.entity.ProductType;
import com.nsu.aircraftenterprize.model.ProductCategoryModel;
import com.nsu.aircraftenterprize.model.ProductTypeModel;
import com.nsu.aircraftenterprize.rest.ProductCategoryRequestDTO;
import com.nsu.aircraftenterprize.rest.ProductTypeRequestDTO;
import com.nsu.aircraftenterprize.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/product-type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @PostMapping
    public ResponseEntity<?> addProductType(@RequestBody ProductTypeRequestDTO request) {
        try {
            productTypeService.addProductType(request);
            return ResponseEntity.ok("Product category added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> getProductTypes() {
        try {
            List<ProductTypeModel> productTypeModels = new ArrayList<>();
            productTypeService.getAllProductTypes().forEach(productType -> productTypeModels.add(ProductTypeModel.toModel(productType)));
            return ResponseEntity.ok(productTypeModels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{category_id}")
    public ResponseEntity<?> getTypesByCategory(@PathVariable Long category_id) {
        try {
            List<ProductTypeModel> productTypeModels = new ArrayList<>();
            productTypeService.getProductTypesByCategory(category_id).forEach(productType -> productTypeModels.add(ProductTypeModel.toModel(productType)));
            return ResponseEntity.ok(productTypeModels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteType(@RequestBody Long typeId) {
        try {
            productTypeService.deleteType(typeId);
            return ResponseEntity.ok("Product type deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
