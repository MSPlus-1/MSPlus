package com.part3.msplus.board.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchRequest {
    private String searchType;
    private String searchKeyword;
}
