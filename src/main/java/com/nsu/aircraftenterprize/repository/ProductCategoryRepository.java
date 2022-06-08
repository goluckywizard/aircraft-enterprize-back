package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
    ProductCategory findByName(String name);
}
