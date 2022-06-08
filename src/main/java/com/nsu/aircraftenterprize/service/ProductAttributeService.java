package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.*;
import com.nsu.aircraftenterprize.repository.ProductAttributeRepository;
import com.nsu.aircraftenterprize.repository.ProductCategoryRepository;
import com.nsu.aircraftenterprize.rest.EmployeeAttributeRequestDTO;
import com.nsu.aircraftenterprize.rest.ProductAttributeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService {
    @Autowired
    ProductAttributeRepository attributeRepository;
    @Autowired
    ProductCategoryRepository categoryRepository;

    public List<ProductAttribute> getAllAttributesByCategory(Long categoryId) {
        ProductCategory category = categoryRepository.findById(categoryId).get();
        return attributeRepository.findAllByProductCategory(category);
    }

    public void addAttribute(ProductAttributeRequestDTO request) {
        ProductCategory category = categoryRepository.findById(request.getCategory_id()).get();
        ProductAttribute productAttribute = new ProductAttribute();

        productAttribute.setProductCategoryId(request.getCategory_id());
        productAttribute.setProductCategory(category);
        productAttribute.setAttribute(request.getAttribute());
        productAttribute.setValue(request.getValue());

        attributeRepository.save(productAttribute);
    }
}
