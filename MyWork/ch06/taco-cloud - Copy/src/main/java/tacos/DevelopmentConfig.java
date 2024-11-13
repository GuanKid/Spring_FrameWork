package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;
import tacos.data.UserRepository;

@Profile("!prod")  // Specifies that this configuration will be active only for non-production environments
@Configuration  // Marks this class as a configuration class for Spring
public class DevelopmentConfig {

  @Bean
  public CommandLineRunner dataLoader(IngredientRepository repo,
                                      UserRepository userRepo, PasswordEncoder encoder) { // Defines a CommandLineRunner bean to load data at application startup
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        // Deletes all existing data in the repositories to ensure a clean slate on startup
        repo.deleteAll();
        userRepo.deleteAll();

        // Adds sample ingredients to the Ingredient repository
        repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
        repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
        repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
        repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
        repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
        repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
        repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
        repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
        repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

        // Adds a test user with encoded password for ease of testing
        userRepo.save(new User("habuma", encoder.encode("password"),
                "Craig Walls", "123 North Street", "Cross Roads", "TX",
                "76227", "123-123-1234"));
      }
    };
  }

}
