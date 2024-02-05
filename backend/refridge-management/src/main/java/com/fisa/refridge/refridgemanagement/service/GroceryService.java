package com.fisa.refridge.refridgemanagement.service;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.repository.PurchaseHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroceryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public List<PurchaseHistory> findByItemName(String itemName) {
        return purchaseHistoryRepository.findAllByItemNameContainsOrderByExpirationDateAsc(itemName);
    }

    public List<PurchaseHistory> findByCategoryId(Long categoryId) {
        return purchaseHistoryRepository.findAllByCategoryIdOrderByExpirationDateAsc(categoryId);
    }
}
