package net.javaguidelines.spring_annotations.config;

import net.javaguidelines.spring_annotations.controllers.PizzaController;
import net.javaguidelines.spring_annotations.service.NonVegPizza;
import net.javaguidelines.spring_annotations.service.Pizza;
import net.javaguidelines.spring_annotations.service.VegPizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

// Marks this class as a configuration class for Spring, similar to XML-based configuration
@Configuration
public class AppConfig {

    // Defines a bean for VegPizza, an implementation of Pizza
    @Bean
    public Pizza vegPizza() {
        return new VegPizza();
    }

    // Defines a bean for NonVegPizza, another implementation of Pizza
    @Bean
    public Pizza nonVegPizza() {
        return new NonVegPizza();
    }

    // Defines a bean for PizzaController with custom initialization and destruction methods
    // The pizzaController bean depends on nonVegPizza and is injected via the constructor
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PizzaController pizzaController() {
        return new PizzaController(nonVegPizza());
    }
}
