package com.part3.msplus.category.query.application;

import com.part3.msplus.category.command.domain.entity.Category;
import com.part3.msplus.category.controller.dto.CategoryResponse;
import com.part3.msplus.category.query.dao.CategoryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryReadService {

    private final CategoryDAO categoryDAO;

    public Page<CategoryResponse> getCategories(Pageable pageable) {
        return categoryDAO.findAll(pageable)
                .map(category -> new CategoryResponse(category.getId(), category.getName()));
    }

    // paging 없이 전체 조회
//    public List<CategoryResponse> getCategories() {
//        List<Category> categories = categoryDAO.findAll();
//        return categories.stream()
//                .map(category -> new CategoryResponse(category.getId(), category.getName()))
//                .collect(Collectors.toList());
//    }

}
