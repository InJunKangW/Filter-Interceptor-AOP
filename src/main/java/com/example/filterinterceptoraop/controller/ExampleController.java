package com.example.filterinterceptoraop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ExampleController {

    @GetMapping("example")
    public String exampleMethod(Model model) {
        log.error("controller called");
        model.addAttribute("message", "controller called");
        log.error("view made");
        return "example";
    }
}
