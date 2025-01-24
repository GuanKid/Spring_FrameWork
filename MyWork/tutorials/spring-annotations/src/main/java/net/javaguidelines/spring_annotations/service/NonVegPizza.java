package net.javaguidelines.spring_annotations.service;

// If not specified, this will let Spring inject this class to the controller.
// Note: The `@Component` annotation should be added here for Spring to register this class as a bean.
// It's typically used to mark the class for component scanning, allowing Spring to manage the class as a bean.
// In this case, it is missing. The `@Primary` annotation could be added if there are multiple beans of the same type.

public class NonVegPizza implements Pizza {

    // This method implements the getPizza method from the Pizza interface.
    // It returns a string representing a Non-Veg pizza.
    @Override
    public String getPizza() {
        return "Non Veg Pizza";
    }
}
