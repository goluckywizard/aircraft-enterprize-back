package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.TestField;
import com.nsu.aircraftenterprize.repository.TestFieldRepository;
import com.nsu.aircraftenterprize.rest.TestFieldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestFieldService {
    @Autowired
    TestFieldRepository fieldRepository;

    public List<TestField> getAllTestFields() throws Exception {
        return (List<TestField>) fieldRepository.findAll();
    }
    public void addTestField(TestFieldDTO request) {
        TestField testField = new TestField();
        testField.setName(request.getName());
        fieldRepository.save(testField);
    }
    public TestField getTestFieldById(Long id) {
        return fieldRepository.findById(id).get();
    }
    public void deleteField(Long id) {
        fieldRepository.deleteById(id);
    }
}
