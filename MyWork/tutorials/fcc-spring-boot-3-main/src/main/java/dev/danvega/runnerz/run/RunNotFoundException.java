package dev.danvega.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for handling scenarios where a requested Run is not found.
 * Annotated with `@ResponseStatus` to automatically set the HTTP response status to 404 (Not Found).
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException {

    /**
     * Default constructor for `RunNotFoundException`.
     * Sets a default error message to "Run Not Found".
     */
    public RunNotFoundException() {
        super("Run Not Found");
    }
}
