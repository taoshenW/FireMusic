package com.sfp;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class Application
{
    
    @RequestMapping("/")
    public String greeting() {
        return "<h1 align=\"center\">Hello World!<h1>";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}