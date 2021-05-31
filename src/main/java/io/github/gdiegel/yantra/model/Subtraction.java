package io.github.gdiegel.yantra.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author gdiegel
 */
public final class Subtraction extends Operation implements Computable {

    private static final Logger LOG = LoggerFactory.getLogger(Subtraction.class);

    public Subtraction(Operands ops) {
        super(ops);
    }

    @Override
    public Number compute() {
        final Operands operands = getOperands();
        final Number result = ((BigDecimal) operands.getB()).subtract(((BigDecimal) operands.getA()));
        LOG.info("Computation {result={}}", result);
        return result;
    }

}
