package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.ProductCategory;
import com.nsu.aircraftenterprize.entity.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {
    List<ProductType> findByProductCategory(ProductCategory category);
    ProductType findByName(String name);
}
