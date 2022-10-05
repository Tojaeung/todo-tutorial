package me.tojaeung.todobackend.service;

import lombok.RequiredArgsConstructor;
import me.tojaeung.todobackend.domain.Todo;
import me.tojaeung.todobackend.dto.CreateTodoDto;
import me.tojaeung.todobackend.dto.TodoDto;
import me.tojaeung.todobackend.dto.UpdateTodoDto;
import me.tojaeung.todobackend.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoDto createDto(CreateTodoDto createTodoDto) {
        Todo newTodo = new Todo(createTodoDto.getName(), createTodoDto.getCompleted());
        Todo savedTodo = todoRepository.save(newTodo);
        return new TodoDto(savedTodo);
    }

    public List<TodoDto> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todo -> new TodoDto(todo)).collect(Collectors.toList());
    }

    public List<TodoDto> getTodos(Boolean completed) {
        List<Todo> todos = todoRepository.findByCompleted(completed);
        return todos.stream().map(todo -> new TodoDto(todo)).collect(Collectors.toList());
    }

    public TodoDto getTodoById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) return new TodoDto(todo.get());
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 todo입니다.");
    }

    public TodoDto updateTodo(Long id, UpdateTodoDto updateTodoDto) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todo.get().setName(updateTodoDto.getName());
            todo.get().setCompleted(updateTodoDto.getCompleted());
            todoRepository.save(todo.get());

            return new TodoDto(todo.get()); 
        } else {
            throw new TodoException(404, "업데이트 todo를 찾을 수 없습니다.");
        }
    }

    public void deleteTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) todoRepository.delete(todo.get());
        else throw new RuntimeException("삭제할 todo를 찾을 수 없습니다.");
    }
    
}
