package com.fisa.refridge.refridgemanagement.repository;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import org.springframework.data.repository.CrudRepository;

public interface RefridgeManagementRepository extends CrudRepository<PurchaseHistory, Long> {
}
