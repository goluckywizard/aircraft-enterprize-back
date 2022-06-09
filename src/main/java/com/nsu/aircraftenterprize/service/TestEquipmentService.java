package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.TestEquipment;
import com.nsu.aircraftenterprize.entity.TestField;
import com.nsu.aircraftenterprize.repository.TestEquipmentRepository;
import com.nsu.aircraftenterprize.repository.TestFieldRepository;
import com.nsu.aircraftenterprize.rest.TestEquipmentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestEquipmentService {
    @Autowired
    TestEquipmentRepository equipmentRepository;
    @Autowired
    TestFieldRepository fieldRepository;

    public List<TestEquipment> getAllEquipment() throws Exception {
        return (List<TestEquipment>) equipmentRepository.findAll();
    }
    public void addEquipment(TestEquipmentRequestDTO request) {
        TestField testField = fieldRepository.findById(request.getTestFieldId()).get();

        TestEquipment equipment = new TestEquipment();
        equipment.setName(request.getName());
        equipment.setTestField(testField);

        equipmentRepository.save(equipment);
    }
    public List<TestEquipment> getEquipmentsByField(Long field_id) {
        TestField field = fieldRepository.findById(field_id).get();
        return equipmentRepository.findByTestField(field);
    }
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
