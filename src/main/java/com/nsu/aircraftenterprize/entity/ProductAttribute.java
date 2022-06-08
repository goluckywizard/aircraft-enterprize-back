package com.nsu.aircraftenterprize.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "product_attr")
@IdClass(ProductAttributeKey.class)
public class ProductAttribute {

    @Id
    @Column(name = "category_id")
    private Long productCategoryId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private ProductCategory productCategory;

    @Id
    private String attribute;

    private String value;


}
