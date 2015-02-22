package io.fs39.yantra.controller;

import io.fs39.yantra.exception.ComputationException;
import io.fs39.yantra.model.ComputationResult;
import io.fs39.yantra.model.Operands;
import io.fs39.yantra.model.Subtraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gdiegel
 */
@RestController
public class SubtractionController {

    private static final Logger LOG = LoggerFactory.getLogger(SubtractionController.class);

    @RequestMapping(value = "/subtract/{a}/from/{b}", method = RequestMethod.GET)
    public ComputationResult add(@PathVariable(value = "a") String a,
            @PathVariable(value = "b") String b) {

        ComputationResult result;
        try {
            result = new Subtraction(Operands.asBigDecimal(a, b)).compute();
        } catch (ComputationException e) {
            LOG.warn(e.getMessage());
            return ComputationResult.invalid();
        }

        return result;
    }
}
