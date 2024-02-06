package com.fisa.refridge.refridgemanagement.dto;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PurchaseHistoryResponse {

    private String itemName;

    private Long quantity;

    private String unit;

    private String category;

    private LocalDate expirationDate;

    private LocalDate purchaseDate;

    public PurchaseHistoryResponse(PurchaseHistory purchaseHistory) {
        this.itemName = purchaseHistory.getItemName();
        this.quantity = purchaseHistory.getQuantity();
        this.unit = purchaseHistory.getUnit().getUnit();
        this.category = purchaseHistory.getCategory().getCategory();
        this.expirationDate = purchaseHistory.getExpirationDate();
        this.purchaseDate = purchaseHistory.getPurchaseDate();
    }
}
