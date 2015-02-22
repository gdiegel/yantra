package io.fs39.model;

/**
 *
 * @author gdiegel
 */
public final class ComputationResult {

    private transient final Number result;

    public ComputationResult(Number result) {
        this.result = result;
    }

    public Number getResult() {
        return result;
    }

    public static ComputationResult invalid() {

        return new ComputationResult(Double.NaN);
    }
    
}
