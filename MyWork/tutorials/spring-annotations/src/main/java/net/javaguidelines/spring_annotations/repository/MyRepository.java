package net.javaguidelines.spring_annotations.repository;

import org.springframework.stereotype.Repository;

// @Repository annotation is a specialized form of @Component
// It indicates that this class is a Data Access Object (DAO) and is responsible for encapsulating
// the interaction with the data source (such as a database or external service).
@Repository
public class MyRepository {

    // Method that returns a simple string message
    public String hello() {
        // This message will be returned when the hello() method is called,
        // typically to demonstrate the functionality of the repository
        return "Hello Repository";
    }
}
