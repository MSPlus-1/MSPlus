package com.part3.msplus.board.query.dto;

import lombok.Getter;

@Getter
public enum BoardField {

    BOARD_NAME("boardName"),
    CREATED_AT("createdAt");

    private final String name;
    BoardField(String name) {
        this.name = name;
    }
}
