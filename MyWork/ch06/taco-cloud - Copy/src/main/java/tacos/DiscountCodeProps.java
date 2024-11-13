package tacos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component  // Marks this class as a Spring-managed bean, meaning Spring will automatically instantiate it
@ConfigurationProperties(prefix="taco.discount")  // Binds properties with the "taco.discount" prefix from application properties to this class
@Data  // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods automatically
public class DiscountCodeProps {

  private Map<String, Integer> codes = new HashMap<>();  // Map to store discount codes as keys and their respective discount values (integers)

}
