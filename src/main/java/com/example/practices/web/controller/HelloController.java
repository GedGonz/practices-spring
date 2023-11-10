package com.example.practices.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HelloController {

    @GetMapping("/hola")
    public String Saludar(){
        return "Hola desde spring!!";
    }
}
