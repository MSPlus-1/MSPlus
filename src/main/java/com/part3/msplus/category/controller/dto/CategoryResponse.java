package com.part3.msplus.category.controller.dto;

import lombok.Getter;

@Getter
public class CategoryResponse {

    private Long categoryId;

    private String categoryName;

    public CategoryResponse(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}