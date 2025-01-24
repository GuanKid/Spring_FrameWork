package net.javaguidelines.spring_annotations.lazy;

import org.springframework.stereotype.Component;

// This annotation marks the class as a Spring-managed component (bean)
// Spring will automatically detect and register it during classpath scanning
@Component
public class EagerLoader {

    // Constructor of the class, will be called when the bean is created by Spring
    public EagerLoader() {
        // This message will be printed when the bean is instantiated, indicating the bean is created eagerly
        System.out.println("EagerLoader constructed");
    }
}
