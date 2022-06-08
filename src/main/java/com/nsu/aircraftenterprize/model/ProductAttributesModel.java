package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.EmployeeAttribute;
import com.nsu.aircraftenterprize.entity.ProductAttribute;
import lombok.Data;

@Data
public class ProductAttributesModel {
    String attribute;
    String value;
    public static ProductAttributesModel toModel(ProductAttribute productAttribute) {
        ProductAttributesModel model = new ProductAttributesModel();
        model.setAttribute(productAttribute.getAttribute());
        model.setValue(productAttribute.getValue());
        return model;
    }
}
