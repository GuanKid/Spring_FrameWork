package dev.danvega.runnerz.run;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents a running activity with various attributes like title, duration, miles, and location.
 * The `Run` record is immutable and includes validation constraints for its fields.
 */
public record Run(
        Integer id, // Unique identifier for the run.
        @NotEmpty // Ensures that the title is not null or empty.
        String title, // Title or description of the run.
        LocalDateTime startedOn, // The date and time when the run started.
        LocalDateTime completedOn, // The date and time when the run ended.
        @Positive // Ensures the miles run is a positive value.
        Integer miles, // The distance covered during the run in miles.
        Location location // The location where the run took place (e.g., indoor, outdoor).
) {

    /**
     * Compact constructor for the `Run` record.
     * Validates that the `completedOn` field is after `startedOn`.
     *
     * @throws IllegalArgumentException if `completedOn` is not after `startedOn`.
     */
    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }

    /**
     * Calculates the total duration of the run as a `Duration` object.
     *
     * @return The duration between `startedOn` and `completedOn`.
     */
    public Duration getDuration() {
        return Duration.between(startedOn, completedOn);
    }

    /**
     * Calculates the average pace of the run in minutes per mile.
     *
     * @return The average pace as an integer (minutes per mile).
     */
    public Integer getAvgPace() {
        return Math.toIntExact(getDuration().toMinutes() / miles);
    }
}
