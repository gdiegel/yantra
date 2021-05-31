package io.github.gdiegel.yantra.model;

/**
 * @author gdiegel
 */
public abstract class Operation {

    private final Operands operands;

    public Operation(Operands ops) {
        this.operands = ops;
    }

    public Operands getOperands() {
        return operands;
    }

}
