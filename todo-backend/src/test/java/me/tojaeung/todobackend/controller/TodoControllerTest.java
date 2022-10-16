package me.tojaeung.todobackend.controller;

import me.tojaeung.todobackend.domain.Todo;
import me.tojaeung.todobackend.dto.response.TodoDto;
import me.tojaeung.todobackend.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean   // 실제로 사용되지 않는다.
    private TodoService todoService;

    @Test
    void getTodosShouldReturnTodos() throws Exception {
        ArrayList<TodoDto> todos = new ArrayList<>();
        Todo todo = new Todo("도서관 가기", false);
        TodoDto todoDto = new TodoDto(todo);
        todos.add(todoDto);

        BDDMockito.given(todoService.getTodos()).willReturn(todos);
        
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(todoDto.getName())));
        
        Mockito.verify(todoService).getTodos();
    }
    
    

}
