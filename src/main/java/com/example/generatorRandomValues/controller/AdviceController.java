package com.example.generatorRandomValues.controller;

import com.example.generatorRandomValues.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.UnsupportedTemporalTypeException;

@ControllerAdvice(annotations = RestController.class)
public class AdviceController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(UnsupportedTemporalTypeException.class)
    public ResponseEntity<?> unsupportedTemporalTypeException(UnsupportedTemporalTypeException e) {
        String message = MessageUtil.getMessage("unsupportedTemporalTypeException.message");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
