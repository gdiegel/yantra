package io.github.gdiegel.yantra.controller;

import io.github.gdiegel.yantra.exception.ComputationException;
import io.github.gdiegel.yantra.model.Addition;
import io.github.gdiegel.yantra.model.ComputationResult;
import io.github.gdiegel.yantra.model.Operands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gdiegel
 */
@RestController
public class AdditionController {

    private static final Logger LOG = LoggerFactory.getLogger(AdditionController.class);

    @GetMapping("/add/{a}/to/{b}/")
    public ComputationResult add(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b) {
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
