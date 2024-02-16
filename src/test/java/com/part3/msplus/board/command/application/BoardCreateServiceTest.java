package com.part3.msplus.board.command.application;

import com.part3.msplus.board.command.domain.repository.BoardRepository;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardCreateServiceTest {

    @Autowired
    BoardCreateService boardCreateService;

    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 생성")
    void createBoard() {
        // given
        BoardCreateRequest boardCreateRequest = makeRequest();

        // when
        boardCreateService.createBoard(boardCreateRequest);

        // then
        assertThat(boardRepository.findAll()).hasSize(1);
    }

    private BoardCreateRequest makeRequest() {
        return BoardCreateRequest.builder()
                .memberId(1L)
                .categoryId(1L)
                .boardName("게시글 제목")
                .build();
    }
}