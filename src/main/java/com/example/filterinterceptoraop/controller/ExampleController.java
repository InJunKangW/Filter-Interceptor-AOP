package com.example.filterinterceptoraop.controller;

import com.example.filterinterceptoraop.exception.ExamAOPException;
import com.example.filterinterceptoraop.exception.ExamFilterException;
import com.example.filterinterceptoraop.exception.ExamInterceptorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ExampleController {
    @ExceptionHandler(ExamFilterException.class)
    public String handleExamFilterException(ExamFilterException ex, Model model) {
        log.error("filter exception handled");
        model.addAttribute("message", ex.getMessage());
        return "exampleView";
    }

    @ExceptionHandler(ExamInterceptorException.class)
    public String handleExamInterceptorException(ExamInterceptorException ex, Model model) {
        log.error("interceptor exception handled");
        model.addAttribute("message", ex.getMessage());
        return "exampleView";
    }

    @ExceptionHandler(ExamAOPException.class)
    public String handleExamAOPException(ExamAOPException ex, Model model) {
        log.error("AOP exception handled");
        model.addAttribute("message", ex.getMessage());
        return "exampleView";
    }

    @GetMapping("example")
    public String exampleMethod(Model model) {
        log.error("controller called");
        model.addAttribute("message", "controller called");
        log.error("view made");
        return "exampleView";
    }
}
