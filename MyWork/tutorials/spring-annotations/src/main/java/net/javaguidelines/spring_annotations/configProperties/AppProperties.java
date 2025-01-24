package net.javaguidelines.spring_annotations.configProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Binds the properties prefixed with "app" from application properties file to this class
@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {
    private String name;          // Application name
    private String description;   // Application description
    private String uploadDir;     // Directory for file uploads
    private Security security;    // Nested Security class for security configurations

    // Inner class for security-related properties
    public static class Security {
        private String username;                  // Username for security access
        private String password;                  // Password for security access
        List<String> roles = new ArrayList<>();   // List of roles for access control
        private boolean enabled;                  // Flag indicating if security is enabled

        Map<String, String> permissions = new HashMap<>();  // Permissions for specific actions

        // Getter and setter for username
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        // Getter and setter for password
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // Getter and setter for roles
        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        // Getter and setter for enabled status
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        // Getter and setter for permissions map
        public Map<String, String> getPermissions() {
            return permissions;
        }

        public void setPermissions(Map<String, String> permissions) {
            this.permissions = permissions;
        }
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for upload directory
    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    // Getter and setter for security settings
    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
