package io.github.gdiegel.yantra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gdiegel
 */
public class OperandMissingException extends ComputationException {

    private static final Logger LOG = LoggerFactory.getLogger(ComputationException.class);

    public OperandMissingException() {
        super();
        LOG.error("Operand missing");
    }

    public OperandMissingException(String message, Throwable cause) {
        super(message, cause);
    }
}
