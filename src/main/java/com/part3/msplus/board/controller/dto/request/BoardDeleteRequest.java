package com.part3.msplus.board.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDeleteRequest {

    @NotNull(message = "BOARD_MEMBER_EMPTY")
    private Long memberId;
}
