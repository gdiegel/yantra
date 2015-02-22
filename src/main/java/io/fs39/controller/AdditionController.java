package io.fs39.controller;

import io.fs39.exception.ComputationException;
import io.fs39.model.Addition;
import io.fs39.model.ComputationResult;
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

    @RequestMapping(value = "/add/{augend}/to/{addend}", method = RequestMethod.GET)
    public ComputationResult add(@PathVariable(value = "augend") String augend,
            @PathVariable(value = "addend") String addend) {

        ComputationResult result;
        try {
            result = new Addition(augend, addend).compute();
        } catch (ComputationException e) {
            LOG.warn(e.getMessage());
            return ComputationResult.invalid();
        }

        return result;
    }
}
