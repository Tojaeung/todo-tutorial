package me.tojaeung.todobackend.controller;

import lombok.RequiredArgsConstructor;
import me.tojaeung.todobackend.dto.request.CreateTodoDto;
import me.tojaeung.todobackend.dto.request.UpdateTodoDto;
import me.tojaeung.todobackend.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("")
    public ResponseEntity createTodo(@RequestBody CreateTodoDto createTodoDto) {
        return new ResponseEntity(todoService.createDto(createTodoDto), HttpStatus.CREATED);
    }
    
    @GetMapping("")
    public ResponseEntity getTodos(@RequestParam Optional<Boolean> completed) {
        if (completed.isPresent()) return ResponseEntity.ok(todoService.getTodos(completed.get()));
        else return ResponseEntity.ok(todoService.getTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTodo(@PathVariable Long id, @RequestBody UpdateTodoDto updateTodoDto) {
        return ResponseEntity.ok(todoService.updateTodo(id, updateTodoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
