package com.part3.msplus.category.command.domain.repository;

import com.part3.msplus.category.command.domain.entity.Category;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long categoryId);

    Category save(Category category);

    void deleteById(Long categoryId);
}
