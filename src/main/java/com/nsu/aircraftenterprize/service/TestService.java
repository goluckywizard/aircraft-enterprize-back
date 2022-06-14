package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.repository.EngineerRepository;
import com.nsu.aircraftenterprize.repository.ProductRepository;
import com.nsu.aircraftenterprize.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;
    @Autowired
    EngineerRepository engineerRepository;
    @Autowired
    ProductRepository productRepository;
    
}
