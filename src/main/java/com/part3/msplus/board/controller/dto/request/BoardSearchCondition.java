package com.part3.msplus.board.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Getter
@AllArgsConstructor
public class BoardSearchCondition {
    private SearchRequest searchRequest;
}
