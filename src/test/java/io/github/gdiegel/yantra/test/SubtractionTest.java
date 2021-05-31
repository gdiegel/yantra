package io.github.gdiegel.yantra.test;

import io.github.gdiegel.yantra.exception.OperandMissingException;
import io.github.gdiegel.yantra.model.ComputationResult;
import io.github.gdiegel.yantra.model.Operands;
import io.github.gdiegel.yantra.model.Subtraction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gdiegel
 */
public class SubtractionTest {

    private static ComputationResult result;

    @BeforeAll
    public static void setUp() throws OperandMissingException {
        result = new Subtraction(Operands.asBigDecimal("3", "5")).compute();
    }

    @Test
    public void canGetResultOfAdditionAsDouble() {
        assertThat(result.asDouble()).isEqualTo(2.0);

    }

    @Test
    public void canGetResultOfAdditionAsInteger() {
        assertThat(result.asInteger()).isEqualTo(2);
    }

    @Test
    public void canGetResultOfAdditionAsLong() {
        assertThat(result.asLong()).isEqualTo(2L);
    }

    @Test
    public void canGetResultOfAdditionAsFloat() {
        assertThat(result.asFloat()).isEqualTo(2F);
    }
}
