package com.fisa.refridge.refridgemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "category", nullable = false)
    private String category;

    @OneToMany
    @JoinColumn(name = "item_id")
    private List<PurchaseHistory> purchaseHistories = new ArrayList<>();
}
