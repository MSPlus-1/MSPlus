package com.part3.msplus.board.controller;

import com.part3.msplus.board.command.application.BoardCreateService;
import com.part3.msplus.board.command.application.BoardDeleteService;
import com.part3.msplus.board.command.application.BoardUpdateService;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.request.BoardDeleteRequest;
import com.part3.msplus.board.controller.dto.request.BoardPatchRequest;
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
    private final BoardUpdateService boardUpdateService;
    private final BoardDeleteService boardDeleteService;

    @GetMapping
    public PageResponse<BoardResponse> getBoards(RequestParam requestParam) {
        return this.boardReadService.getBoards(requestParam);
    }
    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        return this.boardCreateService.createBoard(boardCreateRequest);
    }

    @PatchMapping("/{boardId}")
    public BoardResponse updateBoard(@PathVariable(name = "boardId") Long boardId, @RequestBody BoardPatchRequest boardPatchRequest) {
        return this.boardUpdateService.updateBoard(boardId, boardPatchRequest);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable(name = "boardId") Long boardId, @RequestBody BoardDeleteRequest boardDeleteRequest) {
        this.boardDeleteService.softDeleteBoard(boardId, boardDeleteRequest);
    }

}
