package io.github.gdiegel.yantra.controller;

import io.github.gdiegel.yantra.exception.ComputationException;
import io.github.gdiegel.yantra.model.Addition;
import io.github.gdiegel.yantra.model.Operands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gdiegel
 */
@RestController
public class AdditionController {

    @GetMapping("/add/{a}/to/{b}/")
    public Number add(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b) throws ComputationException {
        return new Addition(Operands.asBigDecimal(a, b)).compute();
    }
}
