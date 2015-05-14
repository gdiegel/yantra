package io.fs39.yantra.controller;

import io.fs39.yantra.exception.ComputationException;
import io.fs39.yantra.model.Addition;
import io.fs39.yantra.model.ComputationResult;
import io.fs39.yantra.model.Operands;
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
public class AdditionController {

    private static final Logger LOG = LoggerFactory.getLogger(AdditionController.class);

    @RequestMapping(value = "/add/{a}/to/{b}/", method = RequestMethod.GET)
    public ComputationResult add(@PathVariable(value = "a") String a,
            @PathVariable(value = "b") String b) {

        ComputationResult result;
        try {
            result = new Addition(Operands.asBigDecimal(a, b)).compute();
        } catch (ComputationException e) {
            LOG.warn(e.getMessage());
            return ComputationResult.invalid();
        }

        return result;
    }
}
