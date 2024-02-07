package com.part3.msplus.category.controller;

import com.part3.msplus.category.command.application.CategoryService;
import com.part3.msplus.category.controller.dto.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Long createCategory(@RequestBody CategoryRequest request){
        return categoryService.createCategory(request);
    }

    @DeleteMapping("/{category-id}")
    public void deleteCategory(@PathVariable("category-id") final Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping("/{category-id}")
    public void updateCategory(@PathVariable("category-id") final Long categoryId, @RequestBody CategoryRequest request) {
        categoryService.updateCategory(categoryId, request);
    }

}
