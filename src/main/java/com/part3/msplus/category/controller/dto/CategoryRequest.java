package com.part3.msplus.category.controller.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class CategoryRequest {

    @NonNull
    private String name;

    @Builder
    private CategoryRequest(@NonNull String name) {
        this.name = name;
    }
}
