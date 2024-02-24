package com.part3.msplus.board.query.dao;

import com.part3.msplus.board.command.domain.QBoard;
import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.query.dto.BoardField;
import com.part3.msplus.global.util.QueryDslUtils;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.part3.msplus.board.command.domain.QBoard.board;
import static com.part3.msplus.board.query.dto.BoardField.CREATED_AT;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final JPAQueryFactory jpaQueryFactory;

    public Long findAllCount() {
        return jpaQueryFactory
                .select(board.count())
                .from(board)
                .fetchOne();
    }
    public List<BoardResponse> findAll(SearchRequest searchRequest, Pageable pageable) {
        List<OrderSpecifier> ORDERS = getAllOrderSpecifiers(pageable);

        return jpaQueryFactory
                .select(Projections.constructor(BoardResponse.class, board))
                .from(board)
                .where(searchDtoEq(searchRequest))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(ORDERS.stream().toArray(OrderSpecifier[]::new))
                .fetch();
    }

    private BooleanExpression searchDtoEq(SearchRequest searchRequest) {
        if(!searchRequest.getSearchTarget().isEmpty() && searchRequest.getSearchKeyword() != null) {
            if(searchRequest.getSearchTarget().equals(BoardField.BOARD_NAME.getName())) {
                return board.boardName.contains(searchRequest.getSearchKeyword());
            }
        }

        return null;
    }

    private List<OrderSpecifier> getAllOrderSpecifiers(Pageable pageable) {

        List<OrderSpecifier> ORDERS = new ArrayList<>();

        if (!isEmpty(pageable.getSort())) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()) {
                    case "createdAt":
                        OrderSpecifier<?> orderCreatedAt = QueryDslUtils.getSortedColumn(direction, board, CREATED_AT.getName());
                        ORDERS.add(orderCreatedAt);
                        break;
                    case "boardName":
                        OrderSpecifier<?> orderBoardName = QueryDslUtils.getSortedColumn(direction, board, BoardField.BOARD_NAME.getName());
                        ORDERS.add(orderBoardName);
                        break;
                    default:
                        break;
                }
            }
        }

        return ORDERS;
    }

}
