package com.test.scheduler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @GetMapping("/")
    public String helloWorld() {
        return "Olá mundo!";
    }

}
