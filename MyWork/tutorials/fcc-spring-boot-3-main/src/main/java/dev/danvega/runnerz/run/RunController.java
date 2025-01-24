package dev.danvega.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing `Run` entities.
 * Handles HTTP requests for creating, reading, updating, and deleting runs.
 */
@RestController
@RequestMapping("/api/runs")
class RunController {

    private final JdbcRunRepository runRepository; // Repository for accessing run data.

    /**
     * Constructor injection for the `RunRepository`.
     *
     * @param runRepository the data repository for runs.
     */
    RunController(JdbcRunRepository runRepository) {
        this.runRepository = runRepository;
    }

    /**
     * Handles GET requests to retrieve all runs.
     *
     * @return A list of all `Run` entities.
     */
    @GetMapping
    List<Run> findAll() {
        return runRepository.findAll();
    }

    /**
     * Handles GET requests to retrieve a specific run by ID.
     *
     * @param id The ID of the run to retrieve.
     * @return The `Run` entity with the given ID.
     * @throws ResponseStatusException if the run is not found.
     */
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
        }
        return run.get();
    }

    /**
     * Handles POST requests to create a new run.
     * The request body must be valid according to the `Run` constraints.
     *
     * @param run The `Run` entity to create.
     * @throws ResponseStatusException if validation fails.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    /**
     * Handles PUT requests to update an existing run.
     *
     * @param run The updated `Run` entity.
     * @param id  The ID of the run to update.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    /**
     * Handles DELETE requests to delete a specific run by ID.
     *
     * @param id The ID of the run to delete.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

    /**
     * Handles GET requests to retrieve runs filtered by location.
     *
     * @param location The location to filter runs by.
     * @return A list of runs at the specified location.
     */
    @GetMapping("/search")
    List<Run> findByLocation(@RequestParam String location) {
        return runRepository.findByLocation(location);
    }
}
