package com.nsu.aircraftenterprize.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/requests")
public class RequestsController {
    @GetMapping("/1")
    public ResponseEntity<?> getProductsByManufactureOrDepartment()
}
