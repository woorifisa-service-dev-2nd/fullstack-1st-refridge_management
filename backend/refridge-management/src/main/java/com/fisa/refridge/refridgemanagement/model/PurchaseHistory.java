package com.fisa.refridge.refridgemanagement.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Builder
    public PurchaseHistory(Long categoryId, Long unitId, String itemName, Long quantity, LocalDate expirationDate, LocalDate purchaseDate) {
        this.categoryId = categoryId;
        this.unitId = unitId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.purchaseDate = purchaseDate;
    }
}
