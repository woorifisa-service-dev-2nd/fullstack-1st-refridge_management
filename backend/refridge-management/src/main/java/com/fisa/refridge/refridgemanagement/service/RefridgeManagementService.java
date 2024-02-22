package com.fisa.refridge.refridgemanagement.service;


import com.fisa.refridge.refridgemanagement.dto.CategoryResponse;
import com.fisa.refridge.refridgemanagement.model.Category;
import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.model.Unit;
import com.fisa.refridge.refridgemanagement.repository.CategoryRepository;
import com.fisa.refridge.refridgemanagement.repository.RefridgeManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class RefridgeManagementService {

    private final RefridgeManagementRepository refridgeManagementRepository;
    private final CategoryRepository categoryRepository;

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

    public void delete(Long id) {
        refridgeManagementRepository.deleteById(id);
    }

    public PurchaseHistory findById(Long id) {

        Optional<PurchaseHistory> purchaseHistoryOptional = refridgeManagementRepository.findById(id);
        return purchaseHistoryOptional.orElse(null);
    }
    public PurchaseHistory update(PurchaseHistory ph) {
        return refridgeManagementRepository.save(ph);
    }

    public Iterable<PurchaseHistory> findAll(){
        return refridgeManagementRepository.findAll();
    }

    public List<Category> findCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }
}
