package net.javaguidelines.spring_annotations.service;

// This is an interface that represents the contract for all types of Pizza classes.
// Any class that implements this interface must provide an implementation for the getPizza() method.

public interface Pizza {

    // This method is expected to return the name or type of pizza.
    // The exact implementation will be provided by the classes implementing this interface,
    // such as VegPizza or NonVegPizza.

    String getPizza();
}
