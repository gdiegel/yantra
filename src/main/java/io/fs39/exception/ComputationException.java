package io.fs39.exception;

import org.apache.log4j.Logger;

/**
 *
 * @author gdiegel
 */
public class ComputationException extends Exception {

    private static final Logger LOG = Logger.getLogger(ComputationException.class);

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
