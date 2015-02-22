package io.fs39.yantra.test;

import io.fs39.yantra.exception.OperandMissingException;
import io.fs39.yantra.model.ComputationResult;
import io.fs39.yantra.model.Operands;
import io.fs39.yantra.model.Subtraction;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gdiegel
 */
public class SubtractionTest {

    private static ComputationResult result;

    @BeforeClass
    public static void setUp() throws OperandMissingException {
        result = new Subtraction(Operands.asBigDecimal("3", "5")).compute();
    }

    @Test
    public void canGetResultOfAdditionAsDouble() throws OperandMissingException {

        assertThat(result.asDouble()).isEqualTo(new Double(2.0));

    }

    @Test
    public void canGetResultOfAdditionAsInteger() throws OperandMissingException {

        assertThat(result.asInteger()).isEqualTo(new Integer(2));
    }

    @Test
    public void canGetResultOfAdditionAsLong() throws OperandMissingException {

        assertThat(result.asLong()).isEqualTo(new Long(2));
    }

    @Test
    public void canGetResultOfAdditionAsFloat() throws OperandMissingException {

        assertThat(result.asFloat()).isEqualTo(new Float(2));
    }
}
