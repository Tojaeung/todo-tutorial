package me.tojaeung.todobackend.controller;

import lombok.RequiredArgsConstructor;
import me.tojaeung.todobackend.dto.CreateTodoDto;
import me.tojaeung.todobackend.dto.TodoDto;
import me.tojaeung.todobackend.dto.UpdateTodoDto;
import me.tojaeung.todobackend.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<TodoDto> createTodo(@RequestBody CreateTodoDto createTodoDto) {
        TodoDto todoDto = todoService.createDto(createTodoDto);
        return new ResponseEntity<>(todoDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<TodoDto> getTodos(@RequestParam Optional<Boolean> completed) {
        if (completed.isPresent()) return todoService.getTodos(completed.get());
        else return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public TodoDto updateTodo(@PathVariable Long id, @RequestBody UpdateTodoDto updateTodoDto) {
        return todoService.updateTodo(id, updateTodoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
