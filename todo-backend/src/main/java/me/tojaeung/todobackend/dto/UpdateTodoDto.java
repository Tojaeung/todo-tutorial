package me.tojaeung.todobackend.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateTodoDto {
    private String name;
    private Boolean completed;
    
}
