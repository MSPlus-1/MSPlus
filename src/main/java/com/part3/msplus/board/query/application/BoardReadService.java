package com.part3.msplus.board.query.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.controller.dto.request.BoardSearchCondition;
import com.part3.msplus.board.controller.dto.request.PageRequest;
import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import com.part3.msplus.board.query.dao.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardReadService {

    private final BoardDAO boardDAO;

    public PageResponse<BoardResponse> getBoards(BoardSearchCondition boardSearchCondition, Pageable pageable) {
        List<Board> boards = this.boardDAO.findAll(boardSearchCondition, pageable);

        List<BoardResponse> boardResponses = boards.stream()
                .map(BoardResponse::new)
                .toList();

        // TODO : page 처리. spec 으로 검색 가능하도록.
        return new PageResponse<BoardResponse>(boardResponses, pageable.getPageSize(), 100);
    }
}
