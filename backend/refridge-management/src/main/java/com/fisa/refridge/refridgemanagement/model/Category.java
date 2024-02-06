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
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "category")
    private List<PurchaseHistory> purchaseHistories = new ArrayList<>();

    @Builder
    public Category(Long categoryId) {
        this.categoryId = categoryId;
    }
}
