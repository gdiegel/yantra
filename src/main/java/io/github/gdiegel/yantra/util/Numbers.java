package io.github.gdiegel.yantra.util;

import io.github.gdiegel.yantra.exception.OperandParsingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author gdiegel
 */
public class Numbers {

    private static final Logger LOG = LoggerFactory.getLogger(Numbers.class);

    public static <T extends Number> T fromString(final String fromString, Class<T> type) throws OperandParsingException {
        T toNumber = null;
        try {
            if (type.equals(BigDecimal.class)) {
                toNumber = type.cast(parseBigDecimal(fromString));
            } else if (type.equals(Double.class)) {
                toNumber = type.cast(Double.valueOf(fromString));
            } else if (type.equals(Integer.class)) {
                toNumber = type.cast(Integer.valueOf(fromString));
            } else {
                toNumber = type.cast(NumberFormat.getInstance().parse(fromString));
            }
        } catch (ParseException | ClassCastException e) {
            handleException(fromString, e);
        }
        LOG.info("Parsed operand {fromString={}, toNumber={}, class={}}", fromString, toNumber, type.getCanonicalName());
        return toNumber;
    }

    private static Number parseBigDecimal(String fromString) throws ParseException {
        final DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        df.setParseBigDecimal(true);
        return df.parse(fromString);
    }

    private static void handleException(final String fromString, Exception e) throws OperandParsingException {
        final String m = MessageFormat.format("Couldn't parse string [{0}]", fromString);
        LOG.debug(m, e);
        throw new OperandParsingException(m, e);
    }
}
