package com.part3.msplus.board.query.dao;

import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;

    @BeforeEach
    @Sql("classpath:sql/data.sql")
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    @DisplayName("게시글 목록 조회")
    void findAll() {
        // given
        SearchRequest searchRequest = new SearchRequest("boardName", "게시판1");
        List<Sort.Order> orders = List.of(new Sort.Order(Sort.Direction.DESC, "createdAt"));
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(orders));

        // when
        List<BoardResponse> boardResponses = boardDAO.findAll(searchRequest, pageRequest);

        // then
        assertEquals(1, boardResponses.size());
        assertThat(boardResponses.get(0).getBoardName()).isEqualTo("게시판1");
    }
}