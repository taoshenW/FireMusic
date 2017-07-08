package com.sfp;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RestController
public class Application
{
    
    @RequestMapping("/")
    public String greeting() {
        return "<h1 align=\"center\">Hello World!<h1>";
    }
    
   @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("2MB");
        return factory.createMultipartConfig();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}