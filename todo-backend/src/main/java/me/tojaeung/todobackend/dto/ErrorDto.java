package me.tojaeung.todobackend.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorDto {
    private String msg;

    public ErrorDto(String msg) {
        this.msg = msg;
    }
}
