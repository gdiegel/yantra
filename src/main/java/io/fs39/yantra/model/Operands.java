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

        BigDecimal a = Numbers.fromString(operand1, BigDecimal.class);
        BigDecimal b = Numbers.fromString(operand2, BigDecimal.class);

        LOG.info("Parsed operands {a={}, b={}}", a, b);

        return new Operands(a, b);
    }


}
