package io.fs39.yantra.model;

import io.fs39.yantra.exception.OperandMissingException;

/**
 *
 * @author gdiegel
 */
public interface Computable {

    /**
     * Computes the result of the operation with the given operators.
     *
     * @return the result of the compution
     * @throws io.fs39.yantra.exception.OperandMissingException
     */
    ComputationResult compute() throws OperandMissingException;

}
