package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Engineer;
import com.nsu.aircraftenterprize.entity.Worker;
import lombok.Data;

@Data
public class WorkerModel {
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Long category_id;
    private String category_name;
    private Long brigade;
    private String brigade_name;

    public static WorkerModel toModel(Worker worker) {
        WorkerModel model = new WorkerModel();

        model.setId(worker.getId());
        model.setLastName(worker.getLastName());
        model.setFirstName(worker.getFirstName());
        model.setPatronymic(worker.getPatronymic());
        model.setCategory_id(worker.getEmployeeCategory().getId());
        model.setBrigade(worker.getBrigade().getId());
        model.setCategory_name(worker.getEmployeeCategory().getName());
        model.setBrigade_name(worker.getBrigade().getName());

        return model;
    }
}
