package io.fs39.yantra.test;

import io.fs39.yantra.exception.OperandMissingException;
import io.fs39.yantra.model.Addition;
import io.fs39.yantra.model.ComputationResult;
import io.fs39.yantra.model.Operands;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gdiegel
 */
public class AdditionTest {

    private static ComputationResult result;

    @BeforeClass
    public static void setUp() throws OperandMissingException {
        result = new Addition(Operands.asBigDecimal("1", "2")).compute();
    }

    @Test
    public void canGetResultOfAdditionAsDouble() throws OperandMissingException {
        assertThat(result.asDouble()).isEqualTo(new Double(3.0));

    }

    @Test
    public void canGetResultOfAdditionAsInteger() throws OperandMissingException {
        assertThat(result.asInteger()).isEqualTo(new Integer(3));
    }

    @Test
    public void canGetResultOfAdditionAsLong() throws OperandMissingException {
        assertThat(result.asLong()).isEqualTo(new Long(3));
    }

    @Test
    public void canGetResultOfAdditionAsFloat() throws OperandMissingException {
        assertThat(result.asFloat()).isEqualTo(new Float(3));
    }
}
