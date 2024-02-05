package com.fisa.refridge.refridgemanagement.dto;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GroceryResponse {

    private String itemName;

    private int quantity;

    private LocalDate expirationDate;

    private LocalDate purchaseDate;

    public GroceryResponse(PurchaseHistory purchaseHistory) {
        this.itemName = purchaseHistory.getItemName();
        this.quantity = purchaseHistory.getQuantity();
        this.expirationDate = purchaseHistory.getExpirationDate();
        this.purchaseDate = purchaseHistory.getPurchaseDate();
    }
}
