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
 *
 * @author gdiegel
 */
public class Numbers {

    private static final Logger LOG = LoggerFactory.getLogger(Numbers.class);

    public static <T extends Number> T fromString(final String fromString, Class<T> type) throws OperandMissingException {

        Optional<T> toNumber = Optional.empty();
        NumberFormat nf = NumberFormat.getInstance();
        if (type.equals(BigDecimal.class)) {
            ((DecimalFormat) nf).setParseBigDecimal(true);
            try {
                toNumber = Optional.of((T) ((DecimalFormat) nf).parse(fromString));
            } catch (ParseException e) {
                handleParseException(fromString, e);
            }
        } else {
            try {
                toNumber = Optional.of((T) nf.parse(fromString));
            } catch (ParseException e) {
                handleParseException(fromString, e);
            }
        }

        LOG.info("Parsed operand {fromString={}, toNumber={}}", fromString, toNumber);
        return toNumber.orElseThrow(OperandMissingException::new);
    }

    private static void handleParseException(final String fromString, ParseException e) throws OperandMissingException {

        String m = new StringBuilder("Couldn't parse string [").append(fromString).append("]: ")
                .append(e.getMessage()).toString();
        LOG.warn(m);
        throw new OperandMissingException(m, e);
    }
}
