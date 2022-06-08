package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Product;
import com.nsu.aircraftenterprize.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByProductType(ProductType type);
    Page<Product> findAllByProductType(ProductType type, Pageable page);
}
