package com.part3.msplus.global.exception.dto;

import lombok.Getter;

@Getter
public enum Error {

    // common : 10,000
    INVALID_INPUT_VALUE(10000, "Invalid input value"),
    INVALID_PASSWORD_ALGORITHM(10001, "Invalid password algorithm"),
    INVALID_EMAIL_FORMAT(10002, "Invalid email format"),
    INVALID_PASSWORD_FORMAT(10003, "Invalid password format"),

    // auth : 20,000
    UNAUTHORIZED(20000, "Unauthenticated Access"),
    MISMATCH_PASSWORD(20001, "Mismatch password"),

    // member : 30,000
    MEMBER_NOT_FOUND(30000, "Member not found"),

    // board : 40,000
    BOARD_CREATE_PERMISSION_DENIED(40000, "Board create permission denied"),
    Board_NOT_FOUND(40001, "Board not found"),

    // category : 50,000
    CATEGORY_NOT_FOUND(50000, "Category not found"),
    CATEGORY_NAME_DUPLICATION(50001, "Category name duplication")
    ;

    private final int code;
    private final String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }
}