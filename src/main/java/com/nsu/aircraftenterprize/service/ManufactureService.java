package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.Manufacture;
import com.nsu.aircraftenterprize.model.ManufactureModel;
import com.nsu.aircraftenterprize.repository.ManufactureRepository;
import com.nsu.aircraftenterprize.rest.ManufactureRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ManufactureService {
    @Autowired
    ManufactureRepository manufactureRepository;

    public List<Manufacture> getAllManufacture() throws Exception {
        return (List<Manufacture>) manufactureRepository.findAll();
    }
    public void addManufacture(Long id, String name) {
        Manufacture manufacture = new Manufacture(id, name, new HashSet<>());
        manufactureRepository.save(manufacture);
    }
    public void addManufacture(ManufactureRequestDTO model) {
        Manufacture manufacture = new Manufacture();
        manufacture.setName(model.getName());
        manufactureRepository.save(manufacture);
    }
    public void deleteManufacture(Long manufactureId) {
        Manufacture manufacture = manufactureRepository.findById(manufactureId).get();
        manufactureRepository.delete(manufacture);
    }
}
