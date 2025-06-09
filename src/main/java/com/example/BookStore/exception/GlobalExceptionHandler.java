package com.example.BookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message",ex.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> handleGenericException(Exception ex){
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp",LocalDateTime.now());
        body.put("message",ex.getMessage());
        body.put("status",HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
