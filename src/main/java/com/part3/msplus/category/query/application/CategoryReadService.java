package com.part3.msplus.category.query.application;

import com.part3.msplus.category.command.domain.entity.Category;
import com.part3.msplus.category.controller.dto.CategoryResponse;
import com.part3.msplus.category.query.dao.CategoryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryReadService {

    private final CategoryDAO categoryDAO;

    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryDAO.findAll();
        return categories.stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }
}
