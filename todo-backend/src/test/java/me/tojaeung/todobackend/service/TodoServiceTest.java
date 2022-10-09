package me.tojaeung.todobackend.service;

import me.tojaeung.todobackend.domain.Todo;
import me.tojaeung.todobackend.dto.TodoDto;
import me.tojaeung.todobackend.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class TodoServiceTest {
    @Autowired
    private TodoService todoService;    
    
    @MockBean   // 실제로 사용되지 않는다.
    private TodoRepository todoRepository;

    @Test
    void getTodosShouldReturnTodos() {
        ArrayList<Todo> todos = new ArrayList<>();
        Todo todo = new Todo("안뇽~", false);
        todos.add(todo);

        Mockito.when(todoRepository.findAll()).thenReturn(todos);
        List<TodoDto> todoDtos = todoService.getTodos();
        assertThat(todoDtos).hasSize(1);
    }
}
