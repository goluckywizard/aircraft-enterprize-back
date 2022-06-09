package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.Product;
import lombok.Data;

import java.util.Date;

@Data
public class ProductModel {
    Long id;
    ProductTypeModel type;
    ProductCategoryModel category;
    Date date;

    public static ProductModel toModel(Product product) {
        ProductModel model = new ProductModel();
        model.setType(ProductTypeModel.toModel(product.getProductType()));
        model.setCategory(ProductCategoryModel.toModel(product.getProductType().getProductCategory()));
        model.setId(product.getId());
        model.setDate(product.getCreateTime());
        return model;
    }
}
