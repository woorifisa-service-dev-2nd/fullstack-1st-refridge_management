package com.fisa.refridge.refridgemanagement.service;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.repository.RefridgeManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefridgeManagementServiceImpl implements RefridgeManagementService{

    private final RefridgeManagementRepository refridgeManagementRepository;

    @Override
    public PurchaseHistory save(PurchaseHistory purchaseHistory) {

        if(purchaseHistory.getCategoryId() == 2) {
            purchaseHistory.setExpirationDate(purchaseHistory.getPurchaseDate().plusDays(7));
        } else if(purchaseHistory.getCategoryId() == 3) {
            purchaseHistory.setExpirationDate(purchaseHistory.getPurchaseDate().plusDays(2));
        }

        return refridgeManagementRepository.save(purchaseHistory);
    }
}
