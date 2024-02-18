package com.part3.msplus.global.exception.handler;

import com.part3.msplus.global.dto.CommonResponse;
import com.part3.msplus.global.exception.CustomException;
import com.part3.msplus.global.exception.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.part3.msplus.global.dto.CommonResponse.failed;


@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Application exception handle
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<CommonResponse<ErrorResponse>> handleCustomException(
            final CustomException exception
    ) {
        final ErrorResponse errorResponse = new ErrorResponse(exception.getError());

        return new ResponseEntity<>(
                failed(errorResponse),
                exception.getHttpStatus()
        );
    }
}