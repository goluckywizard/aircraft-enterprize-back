package com.nsu.aircraftenterprize.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "equip_in_test",
            joinColumns = @JoinColumn(name = "equip_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Set<TestEquipment> equipmentSet = new HashSet<>();
}
