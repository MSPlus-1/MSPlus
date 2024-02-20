package com.part3.msplus.board.query.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import com.part3.msplus.board.query.dao.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardReadService {

    private final BoardDAO boardDAO;

    public PageResponse<BoardResponse> getBoards() {
        List<Board> boards = this.boardDAO.findAll();

        List<BoardResponse> boardResponses = boards.stream()
                .map(BoardResponse::new)
                .toList();

        // TODO : page 처리. spec 으로 검색 가능하도록.
        return new PageResponse<BoardResponse>(boardResponses, 10, 100);
    }
}
