package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.exception.ErrorPageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        log.error(e.getMessage(), e);
        return "error";
    }
}
