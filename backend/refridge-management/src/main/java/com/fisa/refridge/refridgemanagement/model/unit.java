package com.fisa.refridge.refridgemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "units")
public class unit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id", nullable = false)
    private int unitId;

    @Column(name = "unit", nullable = false)
    private String unit;
}
