package io.fs39.yantra.model;

import io.fs39.yantra.exception.OperandMissingException;
import io.fs39.yantra.util.Numbers;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdiegel
 */
public class Operands {

    private static final Logger LOG = LoggerFactory.getLogger(Operands.class);

    private final List<Number> operands;

    public Operands(Number a, Number b) {

        operands = Collections.synchronizedList(new ArrayList<Number>());
        operands.add(a);
        operands.add(b);
    }

    public Number getA() {

        return operands.get(0);
    }

    public Number getB() {

        return operands.get(1);
    }

    public static Operands asBigDecimal(final String operand1, final String operand2) throws OperandMissingException {

        return as(operand1, operand2, BigDecimal.class);
    }

    public static Operands asDouble(final String operand1, final String operand2) throws OperandMissingException {

        return as(operand1, operand2, Double.class);
    }

    public static Operands asInteger(final String operand1, final String operand2) throws OperandMissingException {

        return as(operand1, operand2, Integer.class);
    }

    public static Operands asLong(final String operand1, final String operand2) throws OperandMissingException {

        return as(operand1, operand2, Long.class);
    }

    public static Operands asNumber(final String operand1, final String operand2) throws OperandMissingException {

        return as(operand1, operand2, Number.class);
    }

    private static Operands as(final String operand1, final String operand2, Class clazz) throws OperandMissingException {

        Number a = Numbers.fromString(operand1, clazz);
        Number b = Numbers.fromString(operand2, clazz);

        LOG.info("Parsed operands {a={}, b={}}", a, b);

        return new Operands(a, b);
    }

}
