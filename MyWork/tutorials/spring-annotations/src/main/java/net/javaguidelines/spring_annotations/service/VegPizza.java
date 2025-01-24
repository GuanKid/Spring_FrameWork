package net.javaguidelines.spring_annotations.service;

// This class represents a specific type of Pizza, namely VegPizza.
// It implements the Pizza interface and provides the specific implementation
// for the getPizza() method, returning the name of this pizza type.

public class VegPizza implements Pizza {

    // This method implements the getPizza() method from the Pizza interface.
    // It returns the type of pizza, which in this case is "Veg Pizza".

    @Override
    public String getPizza() {
        return "Veg Pizza";  // Return the name of the pizza
    }
}
