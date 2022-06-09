package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Product;
import com.nsu.aircraftenterprize.entity.ProductCategory;
import com.nsu.aircraftenterprize.entity.ProductType;
import com.nsu.aircraftenterprize.repository.ProductCategoryRepository;
import com.nsu.aircraftenterprize.repository.ProductRepository;
import com.nsu.aircraftenterprize.repository.ProductTypeRepository;
import com.nsu.aircraftenterprize.rest.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductCategoryRepository categoryRepository;

    public void addProduct(ProductRequestDTO request) {
        ProductType type = productTypeRepository.findById(request.getType_id()).get();

        Product product = new Product();
        product.setProductType(type);
        Date date = new Date();
        product.setCreateTime(new Timestamp(date.getTime()));

        productRepository.save(product);
    }
    public List<Product> getProductsByType(Long type_id) {
        ProductType type = productTypeRepository.findById(type_id).get();
        return productRepository.findByProductType(type);
    }
    public List<Product> getProductsByCategory(Long category_id) {
        List<Product> result = new ArrayList<>();
        ProductCategory category = categoryRepository.findById(category_id).get();
        List<ProductType> typeList = productTypeRepository.findByProductCategory(category);
        for (var a : typeList) {
            result.addAll(productRepository.findByProductType(a));
        }
        return result;
    }
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Page<Product> getProductsOnPages(Long type_id, Long page, Long offset) {
        Pageable pageable = PageRequest.of(page.intValue(), offset.intValue());
        ProductType type = productTypeRepository.findById(type_id).get();

        return productRepository.findAllByProductType(type, pageable);
    }
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
    }
}
