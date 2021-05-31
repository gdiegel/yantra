package io.github.gdiegel.yantra.controller;

import io.github.gdiegel.yantra.exception.ComputationException;
import io.github.gdiegel.yantra.model.Operands;
import io.github.gdiegel.yantra.model.Subtraction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gdiegel
 */
@RestController
public class SubtractionController {

    @GetMapping("/subtract/{a}/from/{b}/")
    public Number add(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b) throws ComputationException {
        return new Subtraction(Operands.asBigDecimal(a, b)).compute();
    }
}
