package io.github.gdiegel.yantra.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author gdiegel
 */
public final class Addition extends Operation implements Computable {

    private static final Logger LOG = LoggerFactory.getLogger(Addition.class);

    public Addition(Operands ops) {
        super(ops);
    }

    @Override
    public ComputationResult compute() {
        final Operands operands = getOperands();
        final Number result = ((BigDecimal) operands.getA()).add(((BigDecimal) operands.getB()));
        LOG.info("Computation {result={}}", result);
        return new ComputationResult(result);
    }

}
