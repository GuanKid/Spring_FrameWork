package net.javaguidelines.spring_annotations.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// This annotation marks the class as a Spring-managed component (bean)
// Spring will automatically detect and register it during classpath scanning
@Component
// @Lazy annotation ensures that the bean is not created eagerly during application startup.
// Instead, it will only be created when it is actually needed (lazy loading).
@Lazy
public class LazyLoader {

    // Constructor of the class, will be called when the bean is created by Spring
    public LazyLoader() {
        // This message will be printed when the LazyLoader bean is instantiated,
        // indicating the bean is created lazily (only when required)
        System.out.println("LazyLoader constructed");
    }
}
