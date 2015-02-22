package io.fs39.yantra.test;

import io.fs39.yantra.exception.OperandMissingException;
import io.fs39.yantra.model.Operands;
import java.math.BigDecimal;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdiegel
 */
public class OperandsTest {

    private static final Logger LOG = LoggerFactory.getLogger(OperandsTest.class);

    SoftAssertions softly;

    @Before
    public void setUp() {

        softly = new SoftAssertions();
    }

    @After
    public void tearDown() {

        softly.assertAll();
    }

    @Test
    public void canCreateBigDecimalOperands() throws OperandMissingException {

        Operands ops = Operands.asBigDecimal("1.0", "3.1");

        softly.assertThat(ops.getA()).getClass().equals(BigDecimal.class);
        softly.assertThat(ops.getA()).isEqualTo(new BigDecimal("1.0"));
        softly.assertThat(ops.getB()).isEqualTo(new BigDecimal("3.1"));

    }

    @Test
    public void canCreateDoubleOperands() throws OperandMissingException {

        Operands ops = Operands.asDouble("1.0", "3.1");

        softly.assertThat(ops.getA()).getClass().equals(Double.class);
        softly.assertThat(ops.getA()).isEqualTo(1.0);
        softly.assertThat(ops.getB()).isEqualTo(3.1);
    }

    @Test
    public void canCreateIntegerOperands() throws OperandMissingException {

        Operands ops = Operands.asInteger("1", "3");
        softly.assertThat(ops.getA()).getClass().equals(Integer.class);
        softly.assertThat(ops.getA()).isEqualTo(1);
        softly.assertThat(ops.getB()).isEqualTo(3);
    }

    @Test
    public void canCreateLongOperands() throws OperandMissingException {

        Operands ops = Operands.asLong("1", "3");
        softly.assertThat(ops.getA()).getClass().equals(Long.class);
        softly.assertThat(ops.getA()).isEqualTo(1L);
        softly.assertThat(ops.getB()).isEqualTo(3L);
    }
}
