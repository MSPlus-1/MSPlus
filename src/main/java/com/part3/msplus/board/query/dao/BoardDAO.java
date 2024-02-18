package com.part3.msplus.board.query.dao;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.controller.dto.request.BoardSearchCondition;
import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final JPAQueryFactory jpaQueryFactory;

    public List<Board> findAll(BoardSearchCondition boardSearchCondition, Pageable pageable) {
        return jpaQueryFactory
                .select(new BoardResponse(
                        board.id.as("boardId"),
                        board.name.as("boardName"),
                        board.member_id.as("member"),
                        board.created_at.as("createdAt")
                ))
                .from(board)
                .fetch();
    }

//    private BooleanExpression eqSearchType(SearchRequest searchRequest) {
//        return searchRequest.getSearchType() != null ? board.title.eq(searchRequest.getSearchType()) : null;
//    }
}
