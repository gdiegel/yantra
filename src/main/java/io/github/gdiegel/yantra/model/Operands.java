package io.github.gdiegel.yantra.model;

import io.github.gdiegel.yantra.exception.OperandParsingException;
import io.github.gdiegel.yantra.util.Numbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gdiegel
 */
public class Operands {

    private static final Logger LOG = LoggerFactory.getLogger(Operands.class);

    private final List<Number> operands;

    public Operands(Number a, Number b) {
        operands = Collections.synchronizedList(new ArrayList<>());
        operands.add(a);
        operands.add(b);
    }

    public Number getA() {
        return operands.get(0);
    }

    public Number getB() {
        return operands.get(1);
    }

    public static Operands asBigDecimal(final String operand1, final String operand2) throws OperandParsingException {
        return as(operand1, operand2, BigDecimal.class);
    }

    public static Operands asDouble(final String operand1, final String operand2) throws OperandParsingException {
        return as(operand1, operand2, Double.class);
    }

    public static Operands asInteger(final String operand1, final String operand2) throws OperandParsingException {
        return as(operand1, operand2, Integer.class);
    }

    public static Operands asLong(final String operand1, final String operand2) throws OperandParsingException {
        return as(operand1, operand2, Long.class);
    }

    public static Operands asNumber(final String operand1, final String operand2) throws OperandParsingException {
        return as(operand1, operand2, Number.class);
    }

    private static <T extends Number> Operands as(final String operand1, final String operand2, Class<T> clazz) throws OperandParsingException {
        final Number a = Numbers.fromString(operand1, clazz);
        final Number b = Numbers.fromString(operand2, clazz);
        LOG.info("Parsed operands {a={}, b={}}", a, b);
        return new Operands(a, b);
    }

}
