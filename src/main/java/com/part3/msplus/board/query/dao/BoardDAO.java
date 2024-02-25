package com.part3.msplus.board.query.dao;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.controller.dto.request.RequestParam;
import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.part3.msplus.board.command.domain.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final JPAQueryFactory jpaQueryFactory;

    public List<Board> findAll(SearchRequest searchRequest, Pageable pageable) {
        return jpaQueryFactory
                .select(board)
                .from(board)
                .fetch();
    }

//    private BooleanExpression eqSearchType(SearchRequest searchRequest) {
//        return searchRequest.getSearchType() != null ? board.title.eq(searchRequest.getSearchType()) : null;
//    }
}
