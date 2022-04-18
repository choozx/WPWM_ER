package com.wpwm.er_wpwm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorPageException extends RuntimeException{
    private String pageName;
}
