package com.nsu.aircraftenterprize.model;

import com.nsu.aircraftenterprize.entity.EmployeeCategory;
import com.nsu.aircraftenterprize.entity.ProductCategory;
import lombok.Data;

@Data
public class ProductCategoryModel {
    private Long id;
    private String name;

    public static ProductCategoryModel toModel(ProductCategory productCategory) {
        ProductCategoryModel productCategoryModel = new ProductCategoryModel();
        productCategoryModel.setId(productCategory.getId());
        productCategoryModel.setName(productCategory.getName());
        return productCategoryModel;
    }
}
