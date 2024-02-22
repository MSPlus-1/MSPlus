package com.part3.msplus.board.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestParam {
//    private SearchRequest searchRequest;
    private String searchTarget = "all";
    private String searchKeyword;

    private Integer offset = 0;
    private Integer limit = 50;

    private Sort.Direction direction = Sort.Direction.DESC;

    public PageRequest getPageRequest() {
        return PageRequest.of(offset, limit);
    }

    public SearchRequest getSearchRequest() {
        return new SearchRequest(searchTarget, searchKeyword);
    }
}
