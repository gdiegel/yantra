package io.github.gdiegel.yantra.test;

import io.github.gdiegel.yantra.exception.OperandMissingException;
import io.github.gdiegel.yantra.model.Addition;
import io.github.gdiegel.yantra.model.ComputationResult;
import io.github.gdiegel.yantra.model.Operands;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gdiegel
 */
public class AdditionTest {

    private static ComputationResult result;

    @BeforeAll
    public static void setUp() throws OperandMissingException {
        result = new Addition(Operands.asBigDecimal("1", "2")).compute();
    }

    @Test
    public void canGetResultOfAdditionAsDouble() {
        assertThat(result.asDouble()).isEqualTo(3.0);

    }

    @Test
    public void canGetResultOfAdditionAsInteger() {
        assertThat(result.asInteger()).isEqualTo(3);
    }

    @Test
    public void canGetResultOfAdditionAsLong() {
        assertThat(result.asLong()).isEqualTo(3L);
    }

    @Test
    public void canGetResultOfAdditionAsFloat() {
        assertThat(result.asFloat()).isEqualTo(3F);
    }
}
