package com.part3.msplus.board.query.application;

import com.part3.msplus.board.controller.dto.request.RequestParam;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import com.part3.msplus.board.query.dao.BoardDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BoardReadServiceTest {

    @InjectMocks
    private BoardReadService boardReadService;

    @Mock
    private BoardDAO boardDAO;

    @DisplayName("게시글 목록 조회 서비스 테스트")
    @Test
    void getBoards() {
        // given
        given(boardDAO.findAll(any(), any())).willReturn(boardList());

        // when
        PageResponse<BoardResponse> boardResponses = boardReadService.getBoards(new RequestParam());

        // then
        verify(boardDAO, times(1)).findAll(any(), any());
        assertEquals(boardList().size(), boardResponses.getSize());
    }

    private List<BoardResponse> boardList() {
        BoardResponse boardResponse1 = BoardResponse.builder()
                .boardId(1L)
                .categoryId(1L)
                .boardName("board1")
                .memberId(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .deletedAt(null)
                .build();

        BoardResponse boardResponse2 = BoardResponse.builder()
                .boardId(2L)
                .categoryId(2L)
                .boardName("board2")
                .memberId(2L)
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .deletedAt(null)
                .build();


        return List.of(boardResponse1, boardResponse2);
    }
}