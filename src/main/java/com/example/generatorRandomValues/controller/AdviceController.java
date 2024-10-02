package com.example.generatorRandomValues.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.UnsupportedTemporalTypeException;

@ControllerAdvice(annotations = RestController.class)
public class AdviceController {

    @ExceptionHandler(UnsupportedTemporalTypeException.class)
    public ResponseEntity<?> UnsupportedTemporalTypeException(UnsupportedTemporalTypeException e) {
        return new ResponseEntity<>("Неподходящий шаблон форматирования", HttpStatus.BAD_REQUEST);
    }
}
