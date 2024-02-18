package com.part3.msplus.board.controller;

import com.part3.msplus.board.command.application.BoardCreateService;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.request.BoardSearchCondition;
import com.part3.msplus.board.controller.dto.request.PageRequest;
import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.query.application.BoardReadService;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final BoardReadService boardReadService;

    @GetMapping
    public PageResponse<BoardResponse> getBoards(SearchRequest searchRequest, PageRequest pageRequest) {
        Pageable pageable = pageRequest.of();
        BoardSearchCondition boardSearchCondition = new BoardSearchCondition(searchRequest);
        return this.boardReadService.getBoards(boardSearchCondition, pageable);
    }
    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        // TODO : admin일 경우만 생성 가능
        return this.boardCreateService.createBoard(boardCreateRequest);
    }


}
