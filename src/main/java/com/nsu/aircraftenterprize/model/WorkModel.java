package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Work;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class WorkModel {
    private Long id;
    private DepartmentModel department;
    private StageModel stage;
    private BrigadeModel brigade;

    private Set<Long> products = new HashSet<>();

    public static WorkModel toModel(Work work) {
        WorkModel model = new WorkModel();
        model.setId(work.getId());
        model.setDepartment(DepartmentModel.toModel(work.getDepartment()));
        model.setBrigade(BrigadeModel.toModel(work.getBrigade()));
        model.setStage(StageModel.toModel(work.getStage()));

        for (var p : work.getProducts()) {
            model.getProducts().add(p.getId());
        }
        return model;
    }
}
