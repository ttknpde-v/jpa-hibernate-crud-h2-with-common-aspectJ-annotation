package com.ttknpdev.springbootcrudh2aopbasic.exception.controller;

import com.ttknpdev.springbootcrudh2aopbasic.exception.entity.Warning;
import com.ttknpdev.springbootcrudh2aopbasic.exception.handler.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Warning> resourceNotFoundException(ResourceNotFound ex) {
        Warning warning = new Warning(new Date(), ex.getMessage());
        return new ResponseEntity<>(warning, HttpStatus.NOT_FOUND);
    }
}
