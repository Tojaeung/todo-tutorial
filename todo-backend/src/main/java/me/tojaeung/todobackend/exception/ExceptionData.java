package me.tojaeung.todobackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionData {

    NOT_EXISTING_TODO(1001, "존재하지 않는 todo입니다.", 400),
    NOT_FIND_UPDATED_TODO(1002, "업데이트 todo를 찾을 수 없습니다.", 400),
    ;

    private final int code;
    private final String message;
    private final int statusCode;
}
