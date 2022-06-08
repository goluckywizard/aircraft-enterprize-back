package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.model.EmployeeAttributeModel;
import com.nsu.aircraftenterprize.model.ProductAttributesModel;
import com.nsu.aircraftenterprize.rest.EmployeeAttributeRequestDTO;
import com.nsu.aircraftenterprize.rest.ProductAttributeGETRequestDTO;
import com.nsu.aircraftenterprize.rest.ProductAttributeRequestDTO;
import com.nsu.aircraftenterprize.service.EmployeeAttributeService;
import com.nsu.aircraftenterprize.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/product-attribute")
public class ProductAttributeController {
    @Autowired
    ProductAttributeService service;

    @GetMapping("/{category_id}")
    public ResponseEntity<?> getAttributes(@PathVariable Long category_id) {
        try {
            List<ProductAttributesModel> productAttributesModelList = new ArrayList<>();
            service.getAllAttributesByCategory(category_id).forEach(productAttribute -> productAttributesModelList.add(ProductAttributesModel.toModel(productAttribute)));
            return ResponseEntity.ok(productAttributesModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addAttribute(@RequestBody ProductAttributeRequestDTO request) {
        try {
            service.addAttribute(request);
            return ResponseEntity.ok("Product attribute added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
