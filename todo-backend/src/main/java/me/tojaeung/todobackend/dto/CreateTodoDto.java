package me.tojaeung.todobackend.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTodoDto {
    private String name;
    private Boolean completed;
}
