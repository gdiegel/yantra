package io.github.gdiegel.yantra.test;

import io.github.gdiegel.yantra.exception.OperandParsingException;
import io.github.gdiegel.yantra.model.Addition;
import io.github.gdiegel.yantra.model.Operands;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * @author gdiegel
 */
@TestInstance(PER_CLASS)
public class AdditionTest {

    private Number result;

    @BeforeAll
    void setUp() throws OperandParsingException {
        result = new Addition(Operands.asBigDecimal("1", "2")).compute();
    }

    @Test
    public void canGetResultOfAdditionAsDouble() {
        assertThat(result.doubleValue()).isEqualTo(3.0);

    }

    @Test
    public void canGetResultOfAdditionAsInteger() {
        assertThat(result.intValue()).isEqualTo(3);
    }

    @Test
    public void canGetResultOfAdditionAsLong() {
        assertThat(result.longValue()).isEqualTo(3L);
    }

    @Test
    public void canGetResultOfAdditionAsFloat() {
        assertThat(result.floatValue()).isEqualTo(3F);
    }
}
