package tacos.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Component  // Marks this class as a Spring-managed bean, so it can be injected into other components
@ConfigurationProperties(prefix="taco.orders")  // Binds properties with the prefix "taco.orders" in application.properties or application.yml to this class
@Data  // Lombok annotation to automatically generate getters, setters, toString, equals, and hashCode methods
@Validated  // Ensures that validation annotations (e.g., @Min, @Max) are applied to this class
public class OrderProps {

  // Validation annotations ensure that the pageSize value is between 5 and 25
  @Min(value=5, message="must be between 5 and 25")  // Validates that pageSize is at least 5
  @Max(value=25, message="must be between 5 and 25")  // Validates that pageSize is at most 25
  private int pageSize = 20;  // Default value of 20 if no value is provided in the configuration

}
