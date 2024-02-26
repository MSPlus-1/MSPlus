package com.part3.msplus.category.command.application;

import com.part3.msplus.category.command.domain.entity.Category;
import com.part3.msplus.category.command.domain.repository.CategoryRepository;
import com.part3.msplus.category.controller.dto.CategoryRequest;
import com.part3.msplus.global.exception.CustomException;
import com.part3.msplus.global.exception.dto.Error;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Long createCategory(CategoryRequest request) {
        categoryRepository.findByName(request.getName()).ifPresent(a -> {
            throw new CustomException(Error.CATEGORY_NAME_DUPLICATION);
        });

        final Category category = Category.create(request.getName());
        final Category savedCategory = categoryRepository.save(category);

        return savedCategory.getId();
    }

    public void deleteCategory(final Long categoryId) {
        final Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException(Error.CATEGORY_NOT_FOUND));

        //categoryRepository.deleteById(category.getId());

        category.setDeletedAt();
        categoryRepository.save(category);
    }

    public void updateCategory(final Long categoryId, CategoryRequest request) {
        final Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException(Error.CATEGORY_NOT_FOUND));

        category.updateCategory(categoryId, request.getName());
    }
}
