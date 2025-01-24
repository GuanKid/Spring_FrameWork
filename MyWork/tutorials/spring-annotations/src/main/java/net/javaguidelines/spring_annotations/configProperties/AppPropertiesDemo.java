package net.javaguidelines.spring_annotations.configProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Component class that demonstrates accessing and displaying application properties
@Component
public class AppPropertiesDemo {

    // Injects an instance of AppProperties using Spring's @Autowired annotation
    @Autowired
    private AppProperties appProperties;

    // Method to display the configured application properties
    public void display() {
        System.out.println(
                appProperties.getName() + "\n" +                             // Displays application name
                        appProperties.getDescription() + "\n" +                      // Displays application description
                        appProperties.getUploadDir() + "\n" +                        // Displays upload directory
                        appProperties.getSecurity().getUsername() + "\n" +           // Displays security username
                        appProperties.getSecurity().getPassword() + "\n" +           // Displays security password
                        appProperties.getSecurity().getRoles() + "\n" +              // Displays security roles list
                        appProperties.getSecurity().isEnabled() + "\n" +             // Displays if security is enabled
                        appProperties.getSecurity().getPermissions()                 // Displays permissions map
        );
    }
}
