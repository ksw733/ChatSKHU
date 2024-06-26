package com.skhu.error;

import lombok.Builder;
import org.springframework.http.ResponseEntity;

@Builder
public class ErrorResponse {
    private int status;
    private String name;
    private String code;
    private String message;
    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode e){
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(e.getHttpStatus().value())
                        .name(e.name())
                        .code(e.getCode())
                        .message(e.getMessage())
                        .build()
                );
    }

    // Spring Security 에서는 CustomException 사용 불가능
    public static ErrorResponse of(ErrorCode e){
        return ErrorResponse.builder()
                .status(e.getHttpStatus().value())
                .name(e.name())
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

}