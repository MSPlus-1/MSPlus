package com.part3.msplus.category.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class CategoryRequest {

    @NonNull
    private String name;
}
