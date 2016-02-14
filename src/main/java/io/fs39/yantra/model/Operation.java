package io.fs39.yantra.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gdiegel
 */
public abstract class Operation {

    private static final Logger LOG = LoggerFactory.getLogger(Operation.class);

    private final Operands ops;

    public Operation(Operands ops) {
        this.ops = ops;
    }

    public Operands getOperands() {
        return ops;
    }

}
