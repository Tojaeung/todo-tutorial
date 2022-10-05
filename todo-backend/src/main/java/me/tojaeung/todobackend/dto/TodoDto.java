package me.tojaeung.todobackend.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.tojaeung.todobackend.domain.Todo;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoDto {
    private Long id;
    private String name;
    private Boolean completed;
    
    public TodoDto(Todo todo) {
        this.id = todo.getId();
        this.name = todo.getName();
        this.completed = todo.isCompleted();
    }
}
