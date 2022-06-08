package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.Engineer;
import com.nsu.aircraftenterprize.entity.Product;
import com.nsu.aircraftenterprize.entity.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test, Long> {
    Test findByProduct(Product product);
    List<Test> findByEngineer(Engineer engineer);
}
