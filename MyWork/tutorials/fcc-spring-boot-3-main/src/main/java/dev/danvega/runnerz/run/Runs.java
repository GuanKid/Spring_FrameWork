package dev.danvega.runnerz.run;

import java.util.List;

/**
 * A simple wrapper for a list of `Run` entities.
 * This class can be used to encapsulate a collection of runs for bulk operations or data transfer.
 *
 * @param runs the list of `Run` entities.
 */
public record Runs(List<Run> runs) {
}
