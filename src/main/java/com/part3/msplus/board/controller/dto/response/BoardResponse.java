package com.part3.msplus.board.controller.dto.response;

import com.part3.msplus.board.command.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private Long boardId;

    private Long categoryId;

    private String boardName;

    private Long memberId;

    private LocalDateTime createdAt;

    public BoardResponse(Board board) {
        this.boardId = board.getId();
        this.categoryId = board.getCategory().getId();
        this.boardName = board.getBoardName();
        this.memberId = board.getMember().getId();
        this.createdAt = board.getCreatedAt();
    }
}
