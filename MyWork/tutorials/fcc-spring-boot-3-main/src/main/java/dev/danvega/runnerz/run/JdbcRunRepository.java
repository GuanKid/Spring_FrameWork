package dev.danvega.runnerz.run;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository // Marks this class as a Spring-managed repository bean.
public class JdbcRunRepository implements RunRepository {

    private final JdbcClient jdbcClient;

    /**
     * Constructor to inject the JdbcClient dependency.
     * @param jdbcClient The JdbcClient instance used for database operations.
     */
    public JdbcRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    /**
     * Retrieves all runs from the database.
     * @return A list of all runs.
     */
    public List<Run> findAll() {
        return jdbcClient.sql("select * from run") // SQL query to retrieve all runs.
                .query(Run.class) // Maps the result to the Run class.
                .list(); // Returns the results as a list.
    }

    /**
     * Finds a run by its ID.
     * @param id The ID of the run.
     * @return An Optional containing the run if found, or empty if not found.
     */
    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id,title,started_on,completed_on,miles,location FROM Run WHERE id = :id")
                .param("id", id) // Sets the ID parameter for the query.
                .query(Run.class) // Maps the result to the Run class.
                .optional(); // Returns an Optional result.
    }

    /**
     * Creates a new run in the database.
     * @param run The run to create.
     */
    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO Run(id,title,started_on,completed_on,miles,location) values(?,?,?,?,?,?)")
                .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
                .update(); // Executes the update.

        Assert.state(updated == 1, "Failed to create run " + run.title()); // Ensures exactly one row was affected.
    }

    /**
     * Updates an existing run in the database.
     * @param run The updated run data.
     * @param id The ID of the run to update.
     */
    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("update run set title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? where id = ?")
                .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
                .update(); // Executes the update.

        Assert.state(updated == 1, "Failed to update run " + run.title()); // Ensures exactly one row was affected.
    }

    /**
     * Deletes a run from the database by its ID.
     * @param id The ID of the run to delete.
     */
    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from run where id = :id")
                .param("id", id) // Sets the ID parameter for the query.
                .update(); // Executes the update.

        Assert.state(updated == 1, "Failed to delete run " + id); // Ensures exactly one row was affected.
    }

    /**
     * Counts the total number of runs in the database.
     * @return The total number of runs.
     */
    public int count() {
        return jdbcClient.sql("select * from run")
                .query() // Executes the query.
                .listOfRows() // Retrieves all rows as a list.
                .size(); // Returns the size of the list.
    }

    /**
     * Saves a list of runs to the database.
     * @param runs The list of runs to save.
     */
    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create); // Calls create for each run in the list.
    }

    /**
     * Finds runs by their location.
     * @param location The location to filter by.
     * @return A list of runs matching the location.
     */
    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from run where location = :location")
                .param("location", location) // Sets the location parameter for the query.
                .query(Run.class) // Maps the result to the Run class.
                .list(); // Returns the results as a list.
    }
}
