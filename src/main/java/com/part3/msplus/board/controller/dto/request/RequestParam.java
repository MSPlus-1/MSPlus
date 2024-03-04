package com.part3.msplus.board.controller.dto.request;

import com.part3.msplus.board.query.dto.BoardField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestParam {
    private String searchTarget = "all";
    private String searchKeyword;

    private Integer offset = 0;
    private Integer limit = 50;

    private String sortTarget = BoardField.CREATED_AT.getName();
    private Sort.Direction sort = Sort.Direction.DESC;


    public PageRequest getPageRequest() {
        List<Sort.Order> orders = List.of(new Sort.Order(sort, sortTarget));
        return PageRequest.of(offset, limit, Sort.by(orders));
    }

    public SearchRequest getSearchRequest() {
        return new SearchRequest(searchTarget, searchKeyword);
    }
}
