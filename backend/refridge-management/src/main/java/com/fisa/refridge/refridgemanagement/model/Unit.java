package com.fisa.refridge.refridgemanagement.model;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "units")
public class Unit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id", nullable = false)
    private Long unitId;


    @Column(name = "unit", nullable = false)
    private String unit;

    @OneToMany(mappedBy = "unit")
    private List<PurchaseHistory> purchaseHistories = new ArrayList<>();

    @Builder
    public Unit(Long unitId) {
        this.unitId = unitId;
    }

}
