package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Work;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class WorkModel {
    private Long id;
    private DepartmentModel department;
    private StageModel stage;
    private BrigadeModel brigade;
    private String name;
    private List<ProductModel> products;

    public static WorkModel toModel(Work work) {
        WorkModel model = new WorkModel();
        model.setProducts(new ArrayList<>());
        model.setId(work.getId());
        model.setDepartment(DepartmentModel.toModel(work.getDepartment()));
        model.setBrigade(BrigadeModel.toModel(work.getBrigade()));
        model.setStage(StageModel.toModel(work.getStage()));
        model.setName(work.getName());
        for (var p : work.getProducts()) {
            model.getProducts().add(ProductModel.toModel(p));
        }
        return model;
    }
}
