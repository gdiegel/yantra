package io.github.gdiegel.yantra.test;

import io.github.gdiegel.yantra.exception.OperandMissingException;
import io.github.gdiegel.yantra.model.Operands;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * @author gdiegel
 */
public class OperandsTest {

    @Test
    public void canCreateBigDecimalOperands() throws OperandMissingException {
        final Operands ops = Operands.asBigDecimal("1.0", "3.1");
        assertSoftly(softly -> {
            softly.assertThat(ops.getA()).isInstanceOf(BigDecimal.class);
            softly.assertThat(ops.getA()).isEqualTo(new BigDecimal("1.0"));
            softly.assertThat(ops.getB()).isEqualTo(new BigDecimal("3.1"));
        });
    }

    @Test
    public void canCreateDoubleOperands() throws OperandMissingException {
        final Operands ops = Operands.asDouble("1.0", "3.1");
        assertSoftly(softly -> {
            softly.assertThat(ops.getA()).isInstanceOf(Double.class);
            softly.assertThat(ops.getA()).isEqualTo(1.0);
            softly.assertThat(ops.getB()).isEqualTo(3.1);
        });
    }

    @Test
    public void canCreateIntegerOperands() throws OperandMissingException {
        final Operands ops = Operands.asInteger("1", "3");
        assertSoftly(softly -> {
            softly.assertThat(ops.getA()).isInstanceOf(Integer.class);
            softly.assertThat(ops.getA()).isEqualTo(1);
            softly.assertThat(ops.getB()).isEqualTo(3);
        });
    }

    @Test
    public void canCreateLongOperands() throws OperandMissingException {
        final Operands ops = Operands.asLong("1", "3");
        assertSoftly(softly -> {
            softly.assertThat(ops.getA()).isInstanceOf(Long.class);
            softly.assertThat(ops.getA()).isEqualTo(1L);
            softly.assertThat(ops.getB()).isEqualTo(3L);
        });
    }
}
