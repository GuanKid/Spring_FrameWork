package dev.danvega.runnerz.run;

import java.util.List;
import java.util.Optional;

/**
 * Interface for managing operations related to `Run` entities.
 * This serves as an abstraction layer for data access and manipulation.
 */
public interface RunRepository {

    /**
     * Retrieves all runs from the repository.
     *
     * @return a list of all `Run` entities.
     */
    List<Run> findAll();

    /**
     * Retrieves a specific run by its ID.
     *
     * @param id the unique identifier of the run.
     * @return an `Optional` containing the run if found, or empty if not found.
     */
    Optional<Run> findById(Integer id);

    /**
     * Adds a new run to the repository.
     *
     * @param run the `Run` entity to be added.
     */
    void create(Run run);

    /**
     * Updates an existing run in the repository.
     *
     * @param run the new `Run` entity data.
     * @param id the unique identifier of the run to be updated.
     */
    void update(Run run, Integer id);

    /**
     * Deletes a run from the repository by its ID.
     *
     * @param id the unique identifier of the run to be deleted.
     */
    void delete(Integer id);

    /**
     * Counts the total number of runs in the repository.
     *
     * @return the count of runs as an integer.
     */
    int count();

    /**
     * Saves a list of runs to the repository.
     *
     * @param runs a list of `Run` entities to be added.
     */
    void saveAll(List<Run> runs);

    /**
     * Retrieves a list of runs filtered by their location.
     *
     * @param location the location to filter the runs.
     * @return a list of runs matching the given location.
     */
    List<Run> findByLocation(String location);
}
