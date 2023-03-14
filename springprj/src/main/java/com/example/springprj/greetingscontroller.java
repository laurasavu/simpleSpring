package com.example.springprj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetingscontroller")
public class greetingscontroller {
    @GetMapping(path ="/hello")
    public String hi() {
        return "hi its me";
    }


    @GetMapping("/bye")
    public String bye() {
        return "bye";
    }
}