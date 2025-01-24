package dev.danvega.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository // Indicates that this class is a repository component in the Spring context.
class InMemoryRunRepository implements RunRepository {

    private static final Logger log = LoggerFactory.getLogger(InMemoryRunRepository.class);
    private final List<Run> runs = new ArrayList<>(); // In-memory list to store runs.

    /**
     * Retrieves all runs.
     * @return List of all runs.
     */
    public List<Run> findAll() {
        return runs;
    }

    /**
     * Finds a run by its ID.
     * @param id The ID of the run to find.
     * @return Optional containing the found run or empty if not found.
     * @throws RunNotFoundException if the run is not found.
     */
    public Optional<Run> findById(Integer id) {
        return Optional.ofNullable(runs.stream()
                .filter(run -> run.id() == id)
                .findFirst()
                .orElseThrow(RunNotFoundException::new));
    }

    /**
     * Creates a new run and adds it to the repository.
     * @param run The run to create.
     */
    public void create(Run run) {
        Run newRun = new Run(run.id(),
                run.title(),
                run.startedOn(),
                run.completedOn(),
                run.miles(),
                run.location());
        runs.add(newRun);
    }

    /**
     * Updates an existing run with new data.
     * @param newRun The updated run object.
     * @param id The ID of the run to update.
     */
    public void update(Run newRun, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            var r = existingRun.get();
            log.info("Updating Existing Run: " + existingRun.get());
            runs.set(runs.indexOf(r), newRun); // Replace the existing run with the new run.
        }
    }

    /**
     * Deletes a run by its ID.
     * @param id The ID of the run to delete.
     */
    public void delete(Integer id) {
        log.info("Deleting Run: " + id);
        runs.removeIf(run -> run.id().equals(id)); // Remove the run with the matching ID.
    }

    /**
     * Counts the number of runs in the repository.
     * @return The total number of runs.
     */
    public int count() {
        return runs.size();
    }

    /**
     * Saves a list of runs to the repository.
     * @param runs The list of runs to save.
     */
    public void saveAll(List<Run> runs) {
        runs.stream().forEach(run -> create(run)); // Add each run to the repository.
    }

    /**
     * Finds runs by their location.
     * @param location The location to filter by.
     * @return List of runs matching the location.
     */
    public List<Run> findByLocation(String location) {
        return runs.stream()
                .filter(run -> Objects.equals(run.location(), location))
                .toList(); // Return a list of runs with the matching location.
    }

    /**
     * Initializes the repository with sample data.
     * This method is called after the bean is constructed.
     */
    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR));

        runs.add(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                6,
                Location.INDOOR));
    }
}
