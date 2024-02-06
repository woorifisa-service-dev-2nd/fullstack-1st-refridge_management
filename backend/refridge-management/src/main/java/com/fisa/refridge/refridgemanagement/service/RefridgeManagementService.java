package com.fisa.refridge.refridgemanagement.service;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.repository.RefridgeManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RefridgeManagementService {

    private final RefridgeManagementRepository purchaseHistoryRepository;

    public List<PurchaseHistory> findByItemName(String itemName) {
        return purchaseHistoryRepository.findAllByItemNameContainsOrderByExpirationDateAsc(itemName);
    }

    public List<PurchaseHistory> findByCategory(String category) {
        return purchaseHistoryRepository.findAllByCategory_CategoryOrderByExpirationDateAsc(category);
    }
}
