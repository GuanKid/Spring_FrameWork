package net.javaguidelines.spring_annotations.controllers;

import org.springframework.stereotype.Controller;

// @Controller annotation marks this class as a Spring MVC controller
@Controller
public class MyController {

    // Simple method that returns a greeting string
    public String hello() {
        return "Hello Controller.";
    }
}
