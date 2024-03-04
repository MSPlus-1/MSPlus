package com.part3.msplus.board.controller.dto.request;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.command.domain.Category;
import com.part3.msplus.member.command.domain.Member;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardPatchRequest {

    @NotNull(message = "BOARD_MEMBER_EMPTY")
    private Long memberId;

    private Long categoryId;

    private String boardName;
}
