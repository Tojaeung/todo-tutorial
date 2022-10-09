package me.tojaeung.todobackend.exception;

import lombok.extern.slf4j.Slf4j;
import me.tojaeung.todobackend.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDto> handlerResponseStatusException(ResponseStatusException ex) {
        log.error("에러 발생", ex);
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(errorDto, ex.getStatus());
    }

    @ExceptionHandler(TodoException.class)
    public ResponseEntity<ErrorDto> handlerTodoException(TodoException ex) {
        log.error("todo 익셉션", ex);
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        HttpStatus httpStatus = HttpStatus.resolve(ex.getStatus());
        return new ResponseEntity<>(errorDto, httpStatus);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handlerRuntimeException(RuntimeException ex) {
        log.error("서버 오류", ex);
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
