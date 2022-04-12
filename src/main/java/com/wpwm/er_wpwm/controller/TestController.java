package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private ErUserRepository erUserRepository;


    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/test1")
    public String test1() {
        return erUserRepository.save(new ErUser(null, "유제현")).toString();
    }

    @GetMapping("/test2")
    public String test2() {
        return erUserRepository.findAllByName("유제현").get(0).toString();
    }
}
