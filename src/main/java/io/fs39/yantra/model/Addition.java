package io.fs39.yantra.model;

import io.fs39.yantra.exception.OperandMissingException;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdiegel
 */
public final class Addition extends Operation implements Computable {

    private static final Logger LOG = LoggerFactory.getLogger(Addition.class);

    public Addition(Operands ops){
        
        super(ops);
    }
    
    @Override
    public ComputationResult compute() throws OperandMissingException {

        Operands operands = getOperands();
        final Number result = BigDecimal.valueOf(operands.getA().doubleValue())
                .add(BigDecimal.valueOf(operands.getB().doubleValue()));

        LOG.info("Computation {result={}}", result);
        return new ComputationResult(result);
    }

}
