package com.nsu.aircraftenterprize.controller;

import com.nsu.aircraftenterprize.entity.Product;
import com.nsu.aircraftenterprize.model.BrigadeModel;
import com.nsu.aircraftenterprize.model.ProductModel;
import com.nsu.aircraftenterprize.rest.ProductRequestDTO;
import com.nsu.aircraftenterprize.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            List<ProductModel> productModelList = new ArrayList<>();
            productService.getAllProducts().forEach(product -> productModelList.add(ProductModel.toModel(product)));
            return ResponseEntity.ok(productModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO request) {
        try {
            productService.addProduct(request);
            return ResponseEntity.ok("Product added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/type/{type_id}")
    public ResponseEntity<?> getProductsByType(@PathVariable Long type_id) {
        try {
            List<ProductModel> productModelList = new ArrayList<>();
            productService.getProductsByType(type_id).forEach(product -> productModelList.add(ProductModel.toModel(product)));
            return ResponseEntity.ok(productModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/category/{category_id}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable Long category_id) {
        try {
            List<ProductModel> productModelList = new ArrayList<>();
            productService.getProductsByCategory(category_id).forEach(product -> productModelList.add(ProductModel.toModel(product)));
            return ResponseEntity.ok(productModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/type/{type_id}/{page}/{count}")
    public ResponseEntity<?> getProductsPageByType(@PathVariable Long type_id, @PathVariable Long page, @PathVariable Long count) {
        try {
            List<ProductModel> productModelList = new ArrayList<>();
            productService.getProductsOnPages(type_id, page, count).forEach(product -> productModelList.add(ProductModel.toModel(product)));
            return ResponseEntity.ok(productModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteProduct(@RequestBody Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
