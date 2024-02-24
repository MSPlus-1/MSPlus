package com.part3.msplus.board.controller.dto.response;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.command.domain.Category;
import com.part3.msplus.member.command.domain.Member;
import com.querydsl.core.annotations.QueryProjection;
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

    @QueryProjection
    public BoardResponse(Long boardId, Category category, String boardName, Member member, LocalDateTime createdAt) {
        this.boardId = boardId;
        this.categoryId = category.getId();
        this.boardName = boardName;
        this.memberId = member.getId();
        this.createdAt = createdAt;
    }
}
