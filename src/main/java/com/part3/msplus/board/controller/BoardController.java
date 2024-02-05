package com.part3.msplus.board.controller;

import com.part3.msplus.board.command.application.BoardCreateService;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardCreateService boardCreateService;

    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        // TODO : admin일 경우만 생성 가능
        return this.boardCreateService.createBoard(boardCreateRequest);
    }


}
