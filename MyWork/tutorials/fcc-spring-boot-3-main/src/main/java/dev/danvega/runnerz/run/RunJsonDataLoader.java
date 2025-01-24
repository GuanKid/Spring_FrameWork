package dev.danvega.runnerz.run;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Component to load initial run data from a JSON file into the repository at application startup.
 * Implements `CommandLineRunner` to execute after the Spring Boot application context is initialized.
 */
@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final ObjectMapper objectMapper; // Used for JSON deserialization.
    private final RunRepository runRepository; // Repository to store loaded runs.

    /**
     * Constructor for dependency injection.
     *
     * @param objectMapper   Jackson ObjectMapper for parsing JSON files.
     * @param runRepository  Repository to persist the loaded runs.
     */
    public RunJsonDataLoader(ObjectMapper objectMapper, @Qualifier("jdbcRunRepository") RunRepository runRepository) {
        this.objectMapper = objectMapper;
        this.runRepository = runRepository;
    }

    /**
     * Loads run data from a JSON file and saves it to the repository.
     * Executes automatically at application startup.
     *
     * @param args Command-line arguments (not used here).
     * @throws Exception If an error occurs while loading the data.
     */
    @Override
    public void run(String... args) throws Exception {
        // Check if the repository already contains data.
        if (runRepository.count() == 0) {
            // Load the JSON file from the resources directory.
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                // Deserialize the JSON data into a `Runs` object.
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);

                // Log the number of runs being saved and persist them to the repository.
                log.info("Reading {} runs from JSON data and saving to the repository.", allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());
            } catch (IOException e) {
                // Handle and log exceptions during file reading or deserialization.
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            // Log a message if the repository already contains data.
            log.info("Not loading Runs from JSON data because the repository already contains data.");
        }
    }
}
