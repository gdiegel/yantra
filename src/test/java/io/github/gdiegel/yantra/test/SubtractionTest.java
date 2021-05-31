package io.github.gdiegel.yantra.test;

import io.github.gdiegel.yantra.exception.OperandParsingException;
import io.github.gdiegel.yantra.model.Operands;
import io.github.gdiegel.yantra.model.Subtraction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * @author gdiegel
 */
@TestInstance(PER_CLASS)
class SubtractionTest {

    private Number result;

    @BeforeAll
    void setUp() throws OperandParsingException {
        result = new Subtraction(Operands.asBigDecimal("3", "5")).compute();
    }

    @Test
    public void canGetResultOfAdditionAsDouble() {
        assertThat(result.doubleValue()).isEqualTo(2.0);

    }

    @Test
    public void canGetResultOfAdditionAsInteger() {
        assertThat(result.intValue()).isEqualTo(2);
    }

    @Test
    public void canGetResultOfAdditionAsLong() {
        assertThat(result.longValue()).isEqualTo(2L);
    }

    @Test
    public void canGetResultOfAdditionAsFloat() {
        assertThat(result.floatValue()).isEqualTo(2F);
    }
}
