package io.github.gdiegel.yantra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gdiegel
 */
public class ComputationException extends Exception {

    private static final Logger LOG = LoggerFactory.getLogger(ComputationException.class);

    public ComputationException() {
        LOG.error("Computation Exception");
    }

    public ComputationException(String message) {
        super(message);
    }

    public ComputationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComputationException(Throwable cause) {
        super(cause);
    }

    public ComputationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
