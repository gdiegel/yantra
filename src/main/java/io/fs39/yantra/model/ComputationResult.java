package io.fs39.yantra.model;

/**
 * @author gdiegel
 */
public final class ComputationResult {

    private final Number result;

    public ComputationResult(Number result) {
        this.result = result;
    }

    public Number getResult() {
        return result;
    }

    public Float asFloat() {
        return result.floatValue();
    }

    public Long asLong() {
        return result.longValue();
    }

    public Integer asInteger() {
        return result.intValue();
    }

    public Double asDouble() {
        return result.doubleValue();
    }

    public static ComputationResult invalid() {
        return new ComputationResult(Double.NaN);
    }

}
