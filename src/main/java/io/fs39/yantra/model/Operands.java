package io.fs39.yantra.model;

import io.fs39.yantra.exception.OperandMissingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    public static Operands withOperands(final String operand1, final String operand2) throws OperandMissingException {

        Optional<Number> parsedOperand1 = parseString(operand1);
        Optional<Number> parsedOperand2 = parseString(operand2);

        LOG.info("Parsed operands {augend={}, addend={}}", parsedOperand1, parsedOperand2);

        return new Operands(parsedOperand1.get(), parsedOperand2.get());
    }

    private static Optional<Number> parseString(final String toParse) throws OperandMissingException {

        Optional<Number> parsedNumber = Optional.empty();
        try {
            parsedNumber = Optional.of(NumberFormat.getInstance().parse(toParse));
        } catch (ParseException e) {
            LOG.warn(e.getMessage());
            throw new OperandMissingException("Operation needs augent to be a number");
        }

        LOG.info("Parsed {string={}, number={}}", toParse, parsedNumber);
        return parsedNumber;
    }
}
