package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.ProductAttribute;
import com.nsu.aircraftenterprize.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductAttributeRepository extends CrudRepository<ProductAttribute, Long> {
    ProductAttribute findByAttribute(String attribute);
    List<ProductAttribute> findAllByProductCategory(ProductCategory productCategory);
    ProductAttribute findByProductCategoryAndAttribute(ProductCategory productCategory, String attribute);
}
