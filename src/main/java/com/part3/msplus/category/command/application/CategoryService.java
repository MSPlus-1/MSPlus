package com.part3.msplus.category.command.application;

import com.part3.msplus.category.command.domain.entity.Category;
import com.part3.msplus.category.command.domain.repository.CategoryRepository;
import com.part3.msplus.category.controller.dto.CategoryRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Long createCategory(CategoryRequest request) {
        // TODO : 같은 name이 있는지 검증

        final Category category = Category.create(request.getName());
        final Category savedCategory = categoryRepository.save(category);

        return savedCategory.getId();
    }

    public void deleteCategory(final Long categoryId) {
        final Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 카테고리 없음 id : " + categoryId);
                });

        //categoryRepository.deleteById(category.getId());

        category.setDeletedAt();
        categoryRepository.save(category);
    }

    public void updateCategory(final Long categoryId, CategoryRequest request) {
        final Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 카테고리 없음 id : " + categoryId);
                });

        category.updateCategory(categoryId, request.getName());
    }
}
