package com.part3.msplus.board.controller;

import com.part3.msplus.board.command.application.BoardCreateService;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.query.application.BoardReadService;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final BoardReadService boardReadService;

    @GetMapping
    public PageResponse<BoardResponse> getBoards() {
        return this.boardReadService.getBoards();
    }
    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        // TODO : admin일 경우만 생성 가능
        return this.boardCreateService.createBoard(boardCreateRequest);
    }


}
