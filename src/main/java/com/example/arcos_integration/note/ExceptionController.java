package com.example.arcos_integration.note;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,String>> HandleException(RuntimeException ex){
        return new ResponseEntity<>(new HashMap<>(){{put("msg",ex.getLocalizedMessage());}},HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
