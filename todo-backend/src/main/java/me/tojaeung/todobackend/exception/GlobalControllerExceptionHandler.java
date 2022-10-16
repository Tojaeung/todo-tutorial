package me.tojaeung.todobackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalControllerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException businessException) {
        ExceptionData exceptionData = businessException.getExceptionData();
        ExceptionResponse exceptionResponse = new ExceptionResponse(exceptionData);
        log.info("[비즈니스 예외 발생] 에러 코드 : {}, 메세지 : {}", exceptionData.getCode(), exceptionData.getMessage());
        return ResponseEntity.status(exceptionData.getStatusCode())
                .body(exceptionResponse);
    }
}
