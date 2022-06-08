package com.nsu.aircraftenterprize.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "product_category")
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productCategory")
    private Set<ProductAttribute> productAttributes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productCategory")
    private Set<ProductType> productTypes;

    public ProductCategory(String name) {
        this.name = name;
    }

    public ProductCategory(String name, Set<ProductAttribute> productAttributes, Set<ProductType> productTypes) {
        this.name = name;
        this.productAttributes = productAttributes;
        this.productTypes = productTypes;
    }
}
