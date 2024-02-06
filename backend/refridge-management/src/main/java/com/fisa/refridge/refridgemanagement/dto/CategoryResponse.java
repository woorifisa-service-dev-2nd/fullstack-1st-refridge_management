package com.fisa.refridge.refridgemanagement.dto;

import com.fisa.refridge.refridgemanagement.model.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {

    private Long categoryId;
    private String category;

    public CategoryResponse(Category category) {
        this.categoryId = category.getCategoryId();
        this.category = category.getCategory();
    }
}
