package net.javaguidelines.spring_annotations.controllers;

import net.javaguidelines.spring_annotations.service.Pizza;
import net.javaguidelines.spring_annotations.service.VegPizza;
//Autowired automatically injects a spring bean as a dependency
import org.springframework.beans.factory.annotation.Autowired;
//Qualifier lets you choose which Spring bean you want to use
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class PizzaController {
////    Autowired with field
//    @Autowired
    private Pizza pizza;

////    Autowired with constructor
//    @Autowired
//    public PizzaController(@Qualifier("vegPizza") Pizza pizza) {
//     this.pizza = pizza;
//    }

//        @Autowired
    public PizzaController(Pizza pizza) {
     this.pizza = pizza;
    }
//    Autowired with setter method
//    @Autowired
//    public void setVegPizza(VegPizza vegPizza) {
//        this.vegPizza = vegPizza;
//    }

    public String getPizza(){
        return pizza.getPizza();
    }

    public void init(){
        System.out.println("Initialization logic");
    }

    public void destroy(){
        System.out.println("Destruction  logic");
    }
}
