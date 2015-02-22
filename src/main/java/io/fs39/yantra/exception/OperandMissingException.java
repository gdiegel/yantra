package io.fs39.yantra.exception;

import org.apache.log4j.Logger;

/**
 *
 * @author gdiegel
 */
public class OperandMissingException extends ComputationException {

    private static final Logger LOG = Logger.getLogger(ComputationException.class);

    public OperandMissingException() {

        super();
        LOG.error("Operand missing");
    }

    public OperandMissingException(String message) {
        
        super(message);
    }

    public OperandMissingException(String message, Throwable cause) {

        super(message, cause);
    }

    public OperandMissingException(Throwable cause) {
        
        super(cause);
    }

    public OperandMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    

}
