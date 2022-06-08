package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Product;
import lombok.Data;

@Data
public class ProductModel {
    Long id;
    Long type_id;
    public static ProductModel toModel(Product product) {
        ProductModel model = new ProductModel();
        model.setType_id(product.getProductType().getId());
        model.setId(product.getId());
        return model;
    }
}
