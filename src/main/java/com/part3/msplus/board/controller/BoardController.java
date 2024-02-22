package com.part3.msplus.board.controller;

import com.part3.msplus.board.command.application.BoardCreateService;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.request.RequestParam;
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
    public PageResponse<BoardResponse> getBoards(@ModelAttribute RequestParam requestParam) {
        return this.boardReadService.getBoards(requestParam);
    }
    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        // TODO : admin일 경우만 생성 가능
        return this.boardCreateService.createBoard(boardCreateRequest);
    }


}
