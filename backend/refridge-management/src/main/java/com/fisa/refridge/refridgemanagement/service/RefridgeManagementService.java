package com.fisa.refridge.refridgemanagement.service;

import com.fisa.refridge.refridgemanagement.model.Category;
import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.model.Unit;

import com.fisa.refridge.refridgemanagement.repository.RefridgeManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class RefridgeManagementService {

    private final RefridgeManagementRepository refridgeManagementRepository;

    public List<PurchaseHistory> findByItemName(String itemName) {
        return refridgeManagementRepository.findAllByItemNameContainsOrderByExpirationDateAsc(itemName);
    }

    public List<PurchaseHistory> findByCategory(String category) {
        return refridgeManagementRepository.findAllByCategory_CategoryOrderByExpirationDateAsc(category);

    }
    
   public PurchaseHistory save(PurchaseHistory purchaseHistory) {

      if (purchaseHistory.getCategory().getCategoryId() == 2) {
          purchaseHistory.setExpirationDate(purchaseHistory.getPurchaseDate().plusDays(7));
      } else if (purchaseHistory.getCategory().getCategoryId() == 3) {
          purchaseHistory.setExpirationDate(purchaseHistory.getPurchaseDate().plusDays(2));
      }

      return refridgeManagementRepository.save(purchaseHistory);
    }
        
}
