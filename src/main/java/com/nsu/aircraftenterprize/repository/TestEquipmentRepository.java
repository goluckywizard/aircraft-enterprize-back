package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.TestEquipment;
import com.nsu.aircraftenterprize.entity.TestField;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestEquipmentRepository extends CrudRepository<TestEquipment, Long> {
    List<TestEquipment> findByTestField(TestField field);
}
