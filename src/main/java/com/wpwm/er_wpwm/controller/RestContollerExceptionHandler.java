package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.exception.ErrorPageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestContollerExceptionHandler {

    @ExceptionHandler(ErrorPageException.class)
    public String handleErrorPageException(ErrorPageException e){
        log.error(e.getMessage(), e);
        if(e.getPageName().equals("user guide page")){
            return "This is user guide page";
        }
        if(e.getPageName().equals("admin guide page")){
            return "This is admin guide page";
        }
        return "This unknow error page";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        log.error(e.getMessage(), e);
        return "occur exception";
    }
}
