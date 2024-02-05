package com.part3.msplus.board.controller.dto.response;

import com.part3.msplus.board.command.domain.Board;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
public class BoardResponse {

    private Long boardId;

    private Long categoryId;

    private String boardName;

    private Long memberId;

    private ZonedDateTime createdAt;

    public BoardResponse(Board board) {
        this.boardId = board.getId();
        this.categoryId = board.getCategory().getId();
        this.boardName = board.getBoardName();
        this.memberId = board.getMember().getId();
        this.createdAt = board.getCreatedAt();
    }
}
