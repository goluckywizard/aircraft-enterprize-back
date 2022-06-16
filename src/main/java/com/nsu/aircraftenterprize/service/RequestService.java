package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Department;
import com.nsu.aircraftenterprize.entity.Manufacture;
import com.nsu.aircraftenterprize.entity.Product;
import com.nsu.aircraftenterprize.entity.ProductCategory;
import com.nsu.aircraftenterprize.exceptions.BadRequest;
import com.nsu.aircraftenterprize.repository.*;
import com.nsu.aircraftenterprize.rest.requests.Request1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    @Autowired
    WorkRepository workRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ManufactureRepository manufactureRepository;
    @Autowired
    ProductCategoryRepository categoryRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public Page<Product> getProductByFilter(Request1DTO request) throws BadRequest {
        ProductCategory category = null;
        Manufacture manufacture = null;
        Department department = null;

        if (request.getCategoryId() != null) {
            category = categoryRepository.findById(request.getCategoryId()).get();
        }
        if (request.getManufactureId() != null) {
            manufacture = manufactureRepository.findById(request.getManufactureId()).get();
        }
        if (request.getDepartmentId() != null) {
            department = departmentRepository.findById(request.getDepartmentId()).get();
        }
        if (department == null && manufacture == null) {
            throw new BadRequest("Not enough parameters");
        }
        if
    }
}
