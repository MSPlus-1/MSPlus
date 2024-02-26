package com.part3.msplus.board.query.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.controller.dto.request.RequestParam;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import com.part3.msplus.board.query.dao.BoardDAO;
import com.part3.msplus.member.command.domain.Member;
import com.part3.msplus.member.command.domain.vo.Email;
import com.part3.msplus.member.command.domain.vo.MemberInfo;
import com.part3.msplus.member.command.domain.vo.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class BoardReadServiceTest {

    @InjectMocks
    private BoardReadService boardReadService;

    @Mock
    private BoardDAO boardDAO;

    @DisplayName("게시글 목록 조회 테스트")
    @Test
    void getBoards() {
        // given
        doReturn(boardList()).when(boardDAO).findAll(any(), any());

        // when
        List<BoardResponse> = boardReadService.getBoards(new RequestParam());
        // then
    }

    private List<BoardResponse> boardList() {
        Board board1 = Board.builder()
                .member(Member.builder().password(Password.from("1234")).email(Email.from("msplus@test.com")).memberInfo(MemberInfo.of("msplus", "test", "hama", "010-1234-5678")).build())
                .boardName("board1")
                .build();

        Board board2 = Board.builder()
                .member(Member.builder().password(Password.from("1234")).email(Email.from("msplus2@test.com")).memberInfo(MemberInfo.of("msplus2", "test2", "hama2", "010-1234-5678")).build())
                .boardName("board1")
                .build();

        BoardResponse boardResponse1 = new BoardResponse(board1);
        BoardResponse boardResponse2 = new BoardResponse(board2);

        return List.of(boardResponse1, boardResponse2);
    }
}