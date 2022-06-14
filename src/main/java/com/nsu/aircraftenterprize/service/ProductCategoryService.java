package com.nsu.aircraftenterprize.service;


import com.nsu.aircraftenterprize.entity.ProductCategory;
import com.nsu.aircraftenterprize.repository.ProductCategoryRepository;
import com.nsu.aircraftenterprize.rest.ProductCategoryRequestDTO;
import com.nsu.aircraftenterprize.rest.update.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllProductCategories() {
        return (List<ProductCategory>) productCategoryRepository.findAll();
    }

    public void addProductCategory(ProductCategoryRequestDTO request) {
        ProductCategory productCategory = new ProductCategory();
        System.out.println("added");
        productCategory.setName(request.getName());
        productCategoryRepository.save(productCategory);
    }

    public void deleteCategory(Long categoryId) {
        productCategoryRepository.deleteById(categoryId);
    }
    public void updateCategory(Long categoryId, ProductCategoryDTO request) {
        ProductCategory productCategory = productCategoryRepository.findById(categoryId).get();
        productCategory.setName(request.getName());
        productCategoryRepository.save(productCategory);
    }
}
