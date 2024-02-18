package com.part3.msplus.board.command.application;

import com.part3.msplus.board.command.domain.repository.BoardRepository;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.global.exception.CustomException;
import com.part3.msplus.global.exception.dto.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    @DisplayName("게시글 생성 - 관리자가 아닐 경우 생성 실패")
    void createBoardRoleFail() {
        // given
        BoardCreateRequest boardCreateRequest = makeRoleFailRequest();

        // when
        Throwable exception = assertThrows(CustomException.class, () -> boardCreateService.createBoard(boardCreateRequest));
        assertEquals(Error.BOARD_CREATE_PERMISSION_DENIED.getMessage(), exception.getMessage());

    }

    private BoardCreateRequest makeRequest() {
        return BoardCreateRequest.builder()
                .memberId(1L)
                .categoryId(1L)
                .boardName("게시글 제목")
                .build();
    }

    private BoardCreateRequest makeRoleFailRequest() {
        return BoardCreateRequest.builder()
                .memberId(2L)
                .categoryId(1L)
                .boardName("게시글 생성 실패 - 관리자가 아닐 경우")
                .build();
    }
}