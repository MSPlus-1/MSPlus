package com.part3.msplus.board.controller.dto.request;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.command.domain.Category;
import com.part3.msplus.member.command.domain.Member;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardCreateRequest {

    @NotNull(message = "BOARD_MEMBER_EMPTY")
    private Long memberId;

    @NotNull(message = "BOARD_CATEGORY_EMPTY")
    private Long categoryId;

    @NotNull(message = "BOARD_NAME_EMPTY")
    private String boardName;

    public Board toEntity(Category category, Member member) {
        return Board.builder()
                .category(category)
                .member(member)
                .boardName(this.boardName)
                .build();
    }
}
