package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.ProductType;
import lombok.Data;

@Data
public class ProductTypeModel {
    private Long id;
    private String name;
    private Long category_id;
    private String category_name;

    public static ProductTypeModel toModel(ProductType productType) {
        ProductTypeModel model = new ProductTypeModel();
        model.setName(productType.getName());
        model.setId(productType.getId());
        model.setCategory_id(productType.getProductCategory().getId());
        model.setCategory_name(productType.getProductCategory().getName());
        return model;
    }
}
