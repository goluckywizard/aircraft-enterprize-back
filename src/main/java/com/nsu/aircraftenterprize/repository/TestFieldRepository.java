package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.TestEquipment;
import com.nsu.aircraftenterprize.entity.TestField;
import org.springframework.data.repository.CrudRepository;

public interface TestFieldRepository extends CrudRepository<TestField, Long> {
    TestField findByTestEquipmentSetContains(TestEquipment equipment);
}
