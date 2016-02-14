package io.fs39.yantra.util;

import io.fs39.yantra.exception.OperandMissingException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gdiegel
 */
public class Numbers {

    private static final Logger LOG = LoggerFactory.getLogger(Numbers.class);

    public static <T extends Number> T fromString(final String fromString, Class<T> type) throws OperandMissingException {
        Optional<T> toNumber = Optional.empty();
        if (type.equals(BigDecimal.class)) {
            DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
            df.setParseBigDecimal(true);
            try {
                toNumber = Optional.of((T) df.parse(fromString));
            } catch (ParseException e) {
                handleParseException(fromString, e);
            }
        } else if (type.equals(Double.class)) {
            toNumber = Optional.of((T) Double.valueOf(fromString));
        } else if (type.equals(Integer.class)) {
            toNumber = Optional.of((T) Integer.valueOf(fromString));
        } else {
            try {
                NumberFormat nf = NumberFormat.getInstance();
                toNumber = Optional.of((T) nf.parse(fromString));
            } catch (ParseException e) {
                handleParseException(fromString, e);
            }
        }

        LOG.info("Parsed operand {fromString={}, toNumber={}, class={}}", fromString, toNumber.get(), type.getCanonicalName());
        return toNumber.orElseThrow(OperandMissingException::new);
    }

    private static void handleParseException(final String fromString, ParseException e) throws OperandMissingException {
        String m = "Couldn't parse string [" + fromString + "]";
        LOG.warn(m, e);
        throw new OperandMissingException(m, e);
    }
}
