package io.fs39.model;

import io.fs39.exception.OperandMissingException;
import java.math.BigDecimal;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdiegel
 */
public final class Addition implements Computable {

    private static final Logger LOG = LoggerFactory.getLogger(Addition.class);

    private final String augend;
    private final String addend;

    public Addition(String augend, String addend) {

        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public ComputationResult compute() throws OperandMissingException {

        Optional<BigDecimal> parsedAugend = Optional.empty();
        try {
            parsedAugend = Optional.of(BigDecimal.valueOf(Double.valueOf(augend)));
        } catch (NumberFormatException e) {
            LOG.warn(e.getMessage());
            throw new OperandMissingException("Operation needs augent");
        }

        Optional<BigDecimal> parsedAddend = Optional.empty();
        try {
            parsedAddend = Optional.of(BigDecimal.valueOf(Double.valueOf(addend)));
        } catch (NumberFormatException e) {
            LOG.warn(e.getMessage());
            throw new OperandMissingException("Operation needs addend");
        }
        LOG.info("Parsed operands {augend={}, addend={}}", parsedAugend, parsedAddend);

        final Number result = parsedAugend.get().add(parsedAddend.get());

        LOG.info("Computation {result={}}", result);
        return new ComputationResult(result);
    }

}
