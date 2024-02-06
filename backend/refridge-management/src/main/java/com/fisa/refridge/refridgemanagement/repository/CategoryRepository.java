package com.fisa.refridge.refridgemanagement.repository;

import com.fisa.refridge.refridgemanagement.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
