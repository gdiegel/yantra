package io.fs39.yantra.model;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdiegel
 */
public final class Subtraction extends Operation implements Computable {

    private static final Logger LOG = LoggerFactory.getLogger(Subtraction.class);

    public Subtraction(Operands ops) {

        super(ops);
    }

    @Override
    public ComputationResult compute() {

        Operands operands = getOperands();
        final Number result = ((BigDecimal) operands.getB()).subtract(((BigDecimal) operands.getA()));

        LOG.info("Computation {result={}}", result);
        return new ComputationResult(result);
    }

}
