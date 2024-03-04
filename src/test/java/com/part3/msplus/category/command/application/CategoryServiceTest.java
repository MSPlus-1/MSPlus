package com.part3.msplus.category.command.application;

import com.part3.msplus.category.command.domain.repository.CategoryRepository;
import com.part3.msplus.category.controller.dto.CategoryRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("카테고리 name 업데이트")
    void updateCategory() {
        // given
        CategoryRequest categoryRequest = makeRequest();
        Long categoryId = categoryService.createCategory(categoryRequest);
        CategoryRequest updateRequest = CategoryRequest.builder()
                .name("업데이트된 카테고리 이름")
                .build();

        // when
        categoryService.updateCategory(categoryId, updateRequest);

        // then
        assertThat(categoryRepository.findById(categoryId).get().getName()).isEqualTo("업데이트된 카테고리 이름");
    }

    private CategoryRequest makeRequest() {
        return CategoryRequest.builder()
                .name("카테고리 이름")
                .build();
    }


}
