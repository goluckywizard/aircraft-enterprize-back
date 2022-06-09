package com.nsu.aircraftenterprize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "products")
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type")
    private ProductType productType;
    @ManyToMany(mappedBy = "products")
    private Set<Work> works;
    @OneToOne(mappedBy = "product")
    private Test test;
    private Timestamp createTime;

    public Product(ProductType productType) {
        this.productType = productType;
    }
}
