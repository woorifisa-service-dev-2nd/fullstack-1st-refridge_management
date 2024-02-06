package com.fisa.refridge.refridgemanagement.repository;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseHistoryRepository extends CrudRepository<PurchaseHistory, Long> {

    List<PurchaseHistory> findAllByItemNameContainsOrderByExpirationDateAsc(String itemName);

    List<PurchaseHistory> findAllByCategory_CategoryOrderByExpirationDateAsc(String category);
}
