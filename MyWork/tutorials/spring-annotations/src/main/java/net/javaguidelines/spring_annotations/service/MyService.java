package net.javaguidelines.spring_annotations.service;

import org.springframework.stereotype.Service;

// @Service annotation is a specialization of the @Component annotation.
// It marks the class as a service in the service layer, which contains business logic.
// It indicates that this class should be treated as a Spring-managed bean and should be
// available for dependency injection into other components.
@Service
public class MyService {

    // Method that returns a simple string message
    public String hello() {
        // This message will be returned when the hello() method is called,
        // typically to demonstrate the functionality of the service
        return "Hello Service.";
    }
}
