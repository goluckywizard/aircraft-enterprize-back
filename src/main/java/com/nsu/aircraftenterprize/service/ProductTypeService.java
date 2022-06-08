package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.ProductCategory;
import com.nsu.aircraftenterprize.entity.ProductType;
import com.nsu.aircraftenterprize.repository.ProductCategoryRepository;
import com.nsu.aircraftenterprize.repository.ProductTypeRepository;
import com.nsu.aircraftenterprize.rest.ProductTypeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public void addProductType(ProductTypeRequestDTO request) {
        ProductCategory category = productCategoryRepository.findById(request.getCategory_id()).get();

        ProductType type = new ProductType();
        type.setProductCategory(category);
        type.setName(request.getName());

        productTypeRepository.save(type);
    }

    public List<ProductType> getAllProductTypes() {
        return (List<ProductType>) productTypeRepository.findAll();
    }
    public List<ProductType> getProductTypesByCategory(Long category_id) {
        ProductCategory category = productCategoryRepository.findById(category_id).get();
        return productTypeRepository.findByProductCategory(category);
    }
}
